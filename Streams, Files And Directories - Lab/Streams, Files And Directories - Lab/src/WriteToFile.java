import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String path = "C:\\Softuni\\Java Advanced\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String resultFile = "C:\\Softuni\\Java Advanced\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        try {
            InputStream readingFromFile = new FileInputStream(path);
            OutputStream writingOnFile = new FileOutputStream(resultFile);
            int oneByte = readingFromFile.read();
            Set<Character> forbiddenSymbols = new HashSet<>();
            Collections.addAll(forbiddenSymbols, '.', ',', '!', '?');
            while (oneByte >= 0) {
                if (!forbiddenSymbols.contains((char) oneByte)){
                    writingOnFile.write(oneByte);
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
