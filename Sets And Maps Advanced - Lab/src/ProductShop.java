import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Double>> shopMap = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String shopName = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);
            if (!shopMap.containsKey(shopName)) {
                shopMap.put(shopName, new LinkedHashMap<>());
            }
            shopMap.get(shopName).put(product, price);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Double>> shop : shopMap.entrySet()) {
            System.out.println(shop.getKey() + "->");
            for (Map.Entry<String, Double> product : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }
        }

    }
}
