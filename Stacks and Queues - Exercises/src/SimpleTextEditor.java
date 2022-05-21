import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> textHistory = new ArrayDeque<>();
        String text = "";
        textHistory.push(text);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            switch (data[0]){
                case "1":
                    text = text.concat(data[1]);
                    textHistory.push(text);
                    break;
                case "2":
                    int lastElementsCount = Integer.parseInt(data[1]);
                    text = text.substring(0, text.length() - lastElementsCount);
                    textHistory.push(text);
                    break;
                case "3":
                    char element = text.toCharArray()[Integer.parseInt(data[1]) - 1];
                    System.out.println(element);
                    break;
                case "4":
                    if (text.equals(textHistory.peek())){
                        textHistory.pop();
                    }
                    text = textHistory.pop();
                    break;
            }
        }
    }
}
