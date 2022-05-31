import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class SumBytes {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\input.txt"));
        AtomicInteger sumBytes = new AtomicInteger();
        lines.stream()
                .map(String::toCharArray)
                .forEach(charArray -> {
                    int currentLineByteSum = 0;
                    for (char symbol : charArray) {
                        currentLineByteSum += symbol;
                    }
                    sumBytes.addAndGet(currentLineByteSum);
                });
        System.out.println(sumBytes);
    }
}
