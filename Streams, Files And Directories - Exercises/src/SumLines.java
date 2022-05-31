import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new FileInputStream("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\input.txt"));
        while (file.hasNextLine()){
            String line = file.nextLine();
            byte[] lineAsciiValues = line.getBytes();
            int sum = 0;
            for (byte currentByte : lineAsciiValues) {
                sum += currentByte;
            }
            System.out.println(sum);
        }
    }
}
