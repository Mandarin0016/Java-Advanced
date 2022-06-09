import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flour = "flour";
        String pear = "pear";
        String pork = "pork";
        String olive = "olive";
        List<String> firstCharSequence = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> secondCharSequence = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        for (String s : firstCharSequence) {
            if (flour.contains(s)){
                flour = flour.replace(s, "");
            }
            if (pork.contains(s)){
                pork = pork.replace(s, "");
            }
            if (pear.contains(s)){
                pear = pear.replace(s, "");
            }
            if (olive.contains(s)){
                olive = olive.replace(s, "");
            }
        }
        for (String s : secondCharSequence) {
            if (flour.contains(s)){
                flour = flour.replace(s, "");
            }
            if (pork.contains(s)){
                pork = pork.replace(s, "");
            }
            if (pear.contains(s)){
                pear = pear.replace(s, "");
            }
            if (olive.contains(s)){
                olive = olive.replace(s, "");
            }
        }
        List<String> wordsFound = new ArrayList<>();
        int wordFound = 0;
        if (pear.equals("")){
            wordFound++;
            wordsFound.add("pear");
        }
        if (flour.equals("")){
            wordFound++;
            wordsFound.add("flour");
        }
        if (pork.equals("")){
            wordFound++;
            wordsFound.add("pork");
        }
        if (olive.equals("")){
            wordFound++;
            wordsFound.add("olive");
        }
        System.out.printf("Words found: %d%n", wordFound);
        wordsFound.forEach(System.out::println);
    }
}
