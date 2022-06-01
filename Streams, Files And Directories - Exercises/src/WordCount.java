import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new FileInputStream("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\words.txt"));
        Map<String, Integer> words = new HashMap<>();
        while (inputFile.hasNext()){
            words.put(inputFile.next(), 0);
        }
        Scanner reader = new Scanner(new FileInputStream("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\text.txt"));
        while (reader.hasNext()){
            String currentWord = reader.next();
            if (words.containsKey(currentWord)){
                words.put(currentWord, words.get(currentWord) + 1);
            }
        }
        PrintWriter writer = new PrintWriter("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\outputTest.txt");
        words.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(element -> {
            //of - 6
            //which - 2
            //The - 1
            System.out.printf("%s - %d%n", element.getKey(), element.getValue());
        });
        writer.println(5);
        writer.close();
    }
}
