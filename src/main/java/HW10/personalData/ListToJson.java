package HW10.personalData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Queue;
import java.util.Scanner;

import static HW10.personalData.FileToPersonList.fileToPerson;

public class ListToJson {
    public static void main(String[] args) throws IOException {

        InputStream isf = new FileInputStream("PersonalData");
        Scanner scanner = new Scanner(isf);
        Queue<User> personList = fileToPerson(scanner);
        OutputStream fos = new FileOutputStream("PersonalData.json");

        for (User person: personList) {
            Gson gson = new GsonBuilder().create();
            fos.write(gson.toJson(person).getBytes());
        }
    }
}
