package HW13;

import HW13.model.Post;
import HW13.model.Task;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Post> convertResponseStringToListPostIds(String responseString) {
        JsonArray jsonArray = JsonParser.parseString(responseString).getAsJsonArray();
        List<Post> listPost = new ArrayList();
        int count = 0;

        while (count<jsonArray.size()) {
            JsonObject jsonObject = jsonArray.get(count++).getAsJsonObject();
            listPost.add(createUserFromJson(jsonObject));
        }
        return listPost;
    }


    private static Post createUserFromJson(JsonObject jsonObject) {
        Post post = new Post();
        post.setUserId(jsonObject.get("userId").getAsInt());
        post.setId(jsonObject.get("id").getAsInt());
        post.setTitle(jsonObject.get("title").getAsString());
        post.setBody(jsonObject.get("body").getAsString());
        return post;
    }

    public static void writeCommentsToFileByUserID(String response, int UserId, int id) {
        try (FileWriter writer = new FileWriter("user-" + UserId + "-post-" + id + "-comments.json")) {
            writer.write(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Task createTaskFromJson(JsonObject jsonObject) {
        Task task = new Task();
        task.setUserId(jsonObject.get("userId").getAsInt());
        task.setId(jsonObject.get("id").getAsInt());
        task.setTitle(jsonObject.get("title").getAsString());
        task.setCompleted(jsonObject.get("completed").getAsBoolean());
        return task;
    }

    public static List<Task> convertResponseStringToListUncompletedTasks (String responseString) {
        JsonArray jsonArray = JsonParser.parseString(responseString).getAsJsonArray();
        List<Task> listUncompletedTasks = new ArrayList();
        int count = 0;
        while (count<jsonArray.size()) {
            JsonObject jsonObject = jsonArray.get(count).getAsJsonObject();
            Task task = createTaskFromJson(jsonObject);
            count++;
            if (!task.isCompleted()){
                listUncompletedTasks.add(task);
            }
        }
        return listUncompletedTasks;
    }




}


