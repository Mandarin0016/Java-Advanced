package CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Cat> cats = new HashMap<>();
        String[] data = scanner.nextLine().split("\\s+");
        while (!data[0].equals("End")){
            String breed = data[0];
            String name = data[1];
            double thirdParameter = Double.parseDouble(data[2]);
            Cat cat = null;
            switch (breed){
                case "Siamese":
                    cat = new Siamese(name, thirdParameter);
                    break;
                case "Cymric":
                    cat = new Cymric(name, thirdParameter);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, thirdParameter);
                    break;
            }
            cats.put(name, cat);
            data = scanner.nextLine().split("\\s+");
        }
        String catName = scanner.nextLine();
        System.out.println(cats.get(catName));
    }
}
