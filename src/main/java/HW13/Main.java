package HW13;

import HW13.model.User;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        UserClient userClient = new UserClient("https://jsonplaceholder.typicode.com/users");
        System.out.println(userClient.addNewUser(new User()));
        System.out.println(userClient.updateUserByID(5));
        System.out.println(userClient.deleteByUserId(5));
        System.out.println(userClient.getAllUsers());
        System.out.println(userClient.getUserById(5));
        System.out.println(userClient.getUsersByUserName("Leopoldo_Corkery"));
        System.out.println(userClient.getUserById(5));
        userClient.getCommentsForLastPostByUserId(5);
        System.out.println(userClient.getAllUncompletedTask(5));
    }
    }
