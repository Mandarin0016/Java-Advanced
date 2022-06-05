package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            Person newPerson = new Person(data[0], Integer.parseInt(data[1]));
            people.add(newPerson);
        }
        people
                .stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(person -> {
                    String output = String.format("%s - %d", person.getName(), person.getAge());
                    System.out.println(output);
                });
    }
}
