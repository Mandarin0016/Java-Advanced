import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        Path inputFile = Paths.get("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\input.txt");
        PrintWriter printer = new PrintWriter(new FileOutputStream("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\output.txt"));
        AtomicInteger vowelsCount = new AtomicInteger();
        AtomicInteger consonantsCount = new AtomicInteger();
        AtomicInteger punctuationCount = new AtomicInteger();
        List<String> lines = Files.readAllLines(inputFile);
        lines.stream().map(String::toCharArray).forEach(array -> {
            for (char symbol : array) {
                if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u'){
                    vowelsCount.addAndGet(1);
                }else if (symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?'){
                    punctuationCount.addAndGet(1);
                }else if (symbol != 32){
                    consonantsCount.addAndGet(1);
                }
            }
        });
        printer.printf("Vowels: %s%n", vowelsCount);
        printer.printf("Consonants: %s%n", consonantsCount);
        printer.printf("Punctuation: %s", punctuationCount);
        printer.close();
    }
}
