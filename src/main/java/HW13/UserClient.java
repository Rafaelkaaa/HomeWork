package HW13;

import HW13.model.Post;
import HW13.model.Task;
import HW13.model.User;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

class UserClient {
    private final static HttpClient client = HttpClient.newHttpClient();
     String uri;
    HttpRequest request;


    public UserClient(String uri) throws URISyntaxException {
        this.uri = uri;
    }


    public String addNewUser(User user) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(user)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String updateUserByID(int id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "/" + id))
                .method("PATCH", HttpRequest.BodyPublishers.ofString(String.valueOf(id)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public int deleteByUserId(int id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "/" + id))
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }

    public String getAllUsers() throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getUserById(int id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create((uri + "/" + id)))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


    public String getUsersByUserName(String userName) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create((uri + "/users?username=" + userName)))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public Integer getBiggestPostIDByUserId(int id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create((uri + "/" + id + "/posts")))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List <Post> listPost = Utils.convertResponseStringToListPostIds(response.body());
        int biggestId = 0;
        for (Post post :
                listPost) {
            if (post.getId()>biggestId){
                biggestId = post.getId();
            }
        }
        return biggestId;
    }
    public void getCommentsForLastPostByUserId(int userId) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(("https://jsonplaceholder.typicode.com/posts/"
                        + getBiggestPostIDByUserId(userId) + "/comments")))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Utils.writeCommentsToFileByUserID(response.body(), userId, getBiggestPostIDByUserId(userId));
    }

    public String getAllUncompletedTask (int id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create((uri + "/" + id + "/todos")))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Utils.convertResponseStringToListUncompletedTasks (response.body());
        List<Task> listUncompletedTasks = Utils.convertResponseStringToListUncompletedTasks (response.body());
        return new Gson().toJson(listUncompletedTasks);
    }

}
