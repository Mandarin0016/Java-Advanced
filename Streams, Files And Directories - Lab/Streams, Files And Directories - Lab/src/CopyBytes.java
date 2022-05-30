import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "C:\\Softuni\\Java Advanced\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            InputStream readingFromFile = new FileInputStream(path);
            int oneByte = readingFromFile.read();
            while (oneByte >= 0) {
                switch (oneByte) {
                    case 10:
                        System.out.println();
                        break;
                    case 32:
                        System.out.print(" ");
                        break;
                    default:
                        System.out.print(oneByte);
                        break;
                }
                oneByte = readingFromFile.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
