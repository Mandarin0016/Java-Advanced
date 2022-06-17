package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String[] command = scanner.nextLine().split("\\s+");
        int equal = 0;
        int notEqual = 0;
        while (!command[0].equals("END")){
            people.add(new Person(command[0], Integer.parseInt(command[1]), command[2]));
            command = scanner.nextLine().split("\\s+");
        }
        int index = Integer.parseInt(scanner.nextLine());
        Person myGuy = people.get(index - 1);
        for (Person person : people) {
            if (person.compareTo(myGuy) == 0){
                equal++;
            }else {
                notEqual++;
            }
        }
        if (equal > 1){
            System.out.printf("%d %d %d%n", equal, notEqual, people.size());
        }else {
            System.out.println("No matches");
        }
    }
}
