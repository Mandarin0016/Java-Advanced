import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emailMap = new LinkedHashMap<>();
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9_.\\d\\w]+@[A-Za-z0-9]+.(?<domain>[A-Za-z0-9]+)$");
        Matcher domainMatcher;
        String name = scanner.nextLine();
        while (!name.equals("stop")){
            String email = scanner.nextLine();
            domainMatcher = emailPattern.matcher(email);
            if (domainMatcher.find()){
                String domain = domainMatcher.group("domain");
                if (!domain.equalsIgnoreCase("us") && !domain.equalsIgnoreCase("uk") && !domain.equalsIgnoreCase("com")){
                    emailMap.put(name, email);
                }
            }
            name = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : emailMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
