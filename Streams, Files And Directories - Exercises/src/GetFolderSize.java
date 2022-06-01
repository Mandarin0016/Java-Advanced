import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class GetFolderSize {
    public static void main(String[] args) {
        File myDirectory = new File("C:\\Softuni\\Java Advanced\\Streams, Files And Directories - Exercises\\resources\\Exercises Resources");
        AtomicLong filesLength = new AtomicLong();
        if (myDirectory.isDirectory()){
            Arrays.stream(myDirectory.listFiles()).forEach(file -> {
                filesLength.addAndGet(file.length());
            });
        }
        System.out.println("Folder size: " + filesLength);
    }
}
