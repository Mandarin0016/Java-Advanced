import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();
        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("end")){
            String user = input[2].substring(5);
            String IP = input[0].substring(3);
            if (!userLogs.containsKey(user)){
                userLogs.put(user, new LinkedHashMap<>());
            }
            if (!userLogs.get(user).containsKey(IP)){
                userLogs.get(user).put(IP, 1);
            }else {
                userLogs.get(user).put(IP, userLogs.get(user).get(IP) + 1);
            }
            input = scanner.nextLine().split(" ");
        }
        for (Map.Entry<String, Map<String, Integer>> user : userLogs.entrySet()) {
            System.out.println(user.getKey() + ":");
            String currentUserAddressOutput = "";
            for (Map.Entry<String, Integer> address : user.getValue().entrySet()) {
                currentUserAddressOutput = currentUserAddressOutput.concat(address.getKey()).concat(" => ").concat(String.valueOf(address.getValue())).concat(", ");
            }
            currentUserAddressOutput = currentUserAddressOutput.substring(0, currentUserAddressOutput.length() - 2);
            System.out.println(currentUserAddressOutput + ".");
        }

    }
}
