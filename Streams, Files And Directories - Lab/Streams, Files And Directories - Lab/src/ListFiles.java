import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Softuni\\Java Advanced\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()){
                        System.out.printf("%s: [%d]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
