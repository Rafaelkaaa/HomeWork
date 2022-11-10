package HW10.frequencyKeywords;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FrequencyKeywords {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream fis = new FileInputStream("Text.txt");
        Scanner scanner = new Scanner(fis);
        Map<String, Integer> keywordsFrequency = new TreeMap<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine().toLowerCase();
            String[] words = line.split("[\\p{Punct}\\s]+");
            wordProcessing(keywordsFrequency, words);
        }
        List<Map.Entry<String, Integer>> list = keywordsFrequency.entrySet().stream()
                .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());
            System.out.println(list.toString());
        }

    private static void wordProcessing(Map<String, Integer> keywordsFrequency, String[] words) {
        for (String word : words) {
            if (!keywordsFrequency.containsKey(word)) {
                   keywordsFrequency.put(word,1);
                } else {
                    int newValue = keywordsFrequency.get(word) + 1;
                    keywordsFrequency.put(word, newValue);
            }
        }
    }

}