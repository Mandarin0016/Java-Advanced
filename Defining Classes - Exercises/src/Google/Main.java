package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();
        String[] data = scanner.nextLine().split("\\s+");
        while (!data[0].equals("End")) {
            String personName = data[0];
            Person currentPerson;
            switch (data[1]) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    if (!people.containsKey(personName)) {
                        currentPerson = new Person(personName, company);
                        people.put(personName, currentPerson);
                    } else {
                        people.get(personName).setCompany(company);
                    }
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    if (!people.containsKey(personName)) {
                        currentPerson = new Person(personName, pokemon);
                        people.put(personName, currentPerson);
                    } else {
                        people.get(personName).getPokemons().add(pokemon);
                    }
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    if (!people.containsKey(personName)) {
                        currentPerson = new Person(personName, parent);
                        people.put(personName, currentPerson);
                    } else {
                        people.get(personName).getParents().add(parent);
                    }
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Child child = new Child(childName, childBirthday);
                    if (!people.containsKey(personName)){
                        currentPerson = new Person(personName, child);
                        people.put(personName, currentPerson);
                    }else {
                        people.get(personName).getChildren().add(child);
                    }
                    break;
                case "car":
                    String carModel = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carModel, carSpeed);
                    if (!people.containsKey(personName)) {
                        currentPerson = new Person(personName, car);
                        people.put(personName, currentPerson);
                    } else {
                        people.get(personName).setCar(car);
                    }
                    break;
            }
            data = scanner.nextLine().split("\\s+");
        }
        String outputName = scanner.nextLine();
        Person person = people.get(outputName);
        System.out.println(person);
    }
}
