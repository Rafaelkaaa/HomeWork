package HW13;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        User user = new User(13);
        UserClient userClient = new UserClient("https://jsonplaceholder.typicode.com/users");
        user.setUserName("a");
        userClient.add(user);
    }
    }
