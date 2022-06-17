package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Person> peopleByName = new TreeSet<>(new ComparatorByName());
        Set<Person> peopleByAge = new TreeSet<>(new ComparatorByAge());

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            Person person = new Person(tokens[0],
                    Integer.parseInt(tokens[1]));

            peopleByName.add(person);
            peopleByAge.add(person);

        }
        for (Person person : peopleByName) {
            System.out.println(person);
        }

        peopleByAge.forEach(person -> System.out.println(person.toString()));

    }
}