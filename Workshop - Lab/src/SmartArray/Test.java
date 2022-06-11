package SmartArray;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartArray<String> smartArray = new SmartArray<>(String.class);
        //add elements to the array:
        smartArray.add("Ivan"); //["Ivan", "", "", ""]
        smartArray.add("Maria"); //["Ivan", "Maria", "", ""]
        smartArray.add("Peter"); //["Ivan", "Maria", "Peter", ""]
        //delete and return element of a give index:
        smartArray.remove(0); //["Maria", "Peter", "", ""]
        System.out.printf("We regret to say that %s is not a real magician!%n",  smartArray.remove(1)); //["Maria", "", "", ""] and will return Peter to the console
        //add element to a given index:
        smartArray.add(0, "Paul"); //["Paul", "Maria", "", ""] and will return Peter to the console
        //check if an element exist into the smart array:
        boolean isMariaGoingToHistoryOfMagiClass = smartArray.contains("Maria"); // will return true
        System.out.println("Does Harry participating in the \"History of Magic\" class: " + smartArray.contains("Harry")); // will return false to the console
        //get an element of a given index:
        String myDearFriend = smartArray.get(0); // will return Paul
        //get the last element of the smart array:
        String myLastFriend = smartArray.get(); // will return Maria
        //add some more elements to the smart array:
        smartArray.add("Draco"); //["Paul", "Maria", "Draco", ""]
        smartArray.add(2, "Ron Weasley"); //["Paul", "Maria", "Ron", "Draco"]
        //iterate through the smart array and perform some action on every element:
        smartArray.forEach(myFriend -> System.out.println("My dear friend ".concat(myFriend).concat(" is really cool magician!")));
    }
}
