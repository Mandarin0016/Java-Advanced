import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        Path inputFile = Paths.get("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\inputLineNumbers.txt");
        List<String> lines = Files.readAllLines(inputFile);
        BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\output.txt"));
        AtomicInteger lineNumber = new AtomicInteger();
        lines.forEach(line -> {
            lineNumber.addAndGet(1);
            try {
                br.write(lineNumber +". " + line);
                br.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        br.close();
    }
}
