package HW13;

import java.io.IOException;

public interface UserClient {
    void add(User user) throws IOException, InterruptedException;
}
