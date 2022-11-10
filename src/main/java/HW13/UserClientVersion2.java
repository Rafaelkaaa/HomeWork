package HW13;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class UserClientVersion2 implements UserClient {

        private final static HttpClient client = HttpClient.newHttpClient();
        URI uri;
        private final static Gson GSON = new Gson();
        List listUsers;

        public UserClientVersion2(String uri) throws URISyntaxException {
            this.uri = new URI(uri);
        }

        private void setListUsers(User user) throws IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            listUsers = new Gson().fromJson(response.body(), ArrayList.class);
            listUsers.add(user);
        }

        private void delet () throws IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .DELETE()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            response.body();
        }

        public void add(User user) throws IOException, InterruptedException {
            setListUsers(user);
            delet();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .POST(HttpRequest.BodyPublishers.ofString(GSON.toJson(listUsers)))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

    }
}
