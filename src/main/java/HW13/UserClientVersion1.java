package HW13;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.*;
import java.net.http.*;

public class UserClientVersion1 implements UserClient {
    private final static HttpClient client = HttpClient.newHttpClient();
    URI uri;
    private final static Gson GSON = new Gson();


    public UserClientVersion1(String uri) throws URISyntaxException {
        this.uri = new URI(uri);
    }


    public void add(User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(GSON.toJson(user)))
                .build();
       HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
