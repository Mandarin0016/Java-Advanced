import java.io.File;
import java.util.ArrayDeque;
import java.util.List;

public class NestedFolders {
    public static void main(String[] args) {


        String path = "C:\\Softuni\\Java Advanced\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File folder = new File(path);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(folder);

        int folderCounter = 0;

        while (!queue.isEmpty()) {
            File currentFile = queue.poll();

            if (currentFile.isDirectory()) {
                System.out.println(currentFile.getName());
                queue.addAll(List.of(currentFile.listFiles()));
                folderCounter++;
            }
        }

        System.out.printf("%d folders", folderCounter);
    }
}
