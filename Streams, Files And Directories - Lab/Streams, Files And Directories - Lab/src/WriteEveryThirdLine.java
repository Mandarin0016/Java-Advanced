import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Softuni\\Java Advanced\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String resultFilePath = "C:\\Softuni\\Java Advanced\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));
        PrintWriter printer = new PrintWriter(new FileOutputStream(resultFilePath));
        int row = 1;
        while (scanner.hasNext()) {
            if (row % 3 == 0) {
                printer.println(scanner.nextLine());
            } else {
                scanner.nextLine();
            }
            row++;
        }
        printer.close();
    }
}
