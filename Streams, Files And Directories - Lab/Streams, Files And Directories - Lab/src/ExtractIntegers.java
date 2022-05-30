import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String readingFile = "C:\\Softuni\\Java Advanced\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writingFile = "C:\\Softuni\\Java Advanced\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";
        Scanner scanner = new Scanner(new FileInputStream(readingFile));
        PrintWriter myFileWriter = new PrintWriter(writingFile);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                myFileWriter.println(scanner.nextInt());
            }
            scanner.next();
        }
        myFileWriter.close();
    }
}
