package HW10.PhoneNumbers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class PrintValidPhoneNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream fis = new FileInputStream("PhoneNumbers");
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNext()){
            String phoneNumber = scanner.nextLine();
        if (isValidPhoneNumber(phoneNumber)) {
            System.out.println(phoneNumber);
        }
        }

    }

    private static boolean isValidPhoneNumber(String phoneNumber){
        String patternShortNumber = ("^(\\d{3}[-]){2}\\d{4}$");
        String patternFullNumber = ("^[(]\\d{3}[)][ ]\\d{3}[-]\\d{4}$");
        if (phoneNumber.matches(patternShortNumber) ||
        phoneNumber.matches(patternFullNumber)){
return true;
        }
        return false;
    }

}
