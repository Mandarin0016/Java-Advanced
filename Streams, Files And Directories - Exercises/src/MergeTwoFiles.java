import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        List<String> allLines = Files.readAllLines(Path.of("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\inputOne.txt"));
        allLines.addAll(Files.readAllLines(Path.of("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\inputTwo.txt")));
        PrintWriter printer = new PrintWriter(new FileOutputStream("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\output.txt"));
        allLines.forEach(printer::println);
        printer.close();
    }
}
