package HW13;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class UserClient {
    private final static HttpClient client = HttpClient.newHttpClient();
    static String uri;
    static HttpRequest request;


    public UserClient(String uri) throws URISyntaxException {
        this.uri = uri;
    }


    public static String addNewUser() throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String updateUserByID(int id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "/" + id))
                .method("PATCH", HttpRequest.BodyPublishers.ofString(String.valueOf(id)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static int deleteByUserId(int id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "/" + id))
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }

    public static String getAllUsers() throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String getUserById(int id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create((uri + "/" + id)))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("getUserById body() = " + response.body());
        return response.body();
    }


    public static String getUsersByUserName(String userName) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create((uri + "/users?username=" + userName)))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String getPostsByUserId(int id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create((uri + "/" + id + "/posts")))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String getLastPostByUserId(int id) throws IOException, InterruptedException {
        return null;
    }

}
