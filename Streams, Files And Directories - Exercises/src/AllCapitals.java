import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class AllCapitals {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileInputStream("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\input.txt"));
        PrintWriter writer = new PrintWriter(new FileOutputStream("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\output.txt"));
        while (reader.hasNextLine()){
            writer.println(reader.nextLine().toUpperCase());
        }
        writer.close();
        reader.close();
    }
}
