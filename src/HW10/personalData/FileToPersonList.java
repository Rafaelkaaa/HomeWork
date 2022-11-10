package HW10.personalData;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class FileToPersonList {

    protected static Queue <User> fileToPerson(Scanner scanner) {
        Queue <User> personList = new ArrayDeque<>();
        while (scanner.hasNext()) {
            String personalData = scanner.nextLine();
            if (!personalData.equals("name age")) {
                String[] personalDataArray = personalData.split(" ");
                int age = Integer.parseInt(personalDataArray[1]);
                personList.add(new User(personalDataArray[0], age));
            }
        }
        return personList;
    }
}
