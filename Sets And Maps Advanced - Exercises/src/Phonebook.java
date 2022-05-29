import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String[] input = scanner.nextLine().split("-");
        while (!input[0].equals("search")) {
            phonebook.put(input[0], input[1]);
            input = scanner.nextLine().split("-");
        }
        input = scanner.nextLine().split("-");
        while (!input[0].equals("stop")) {
            if (phonebook.containsKey(input[0])){
                System.out.println(input[0] + " -> " + phonebook.get(input[0]));
            }else {
                System.out.printf("Contact %s does not exist.%n", input[0]);
            }
            input = scanner.nextLine().split("-");
        }
    }
}
