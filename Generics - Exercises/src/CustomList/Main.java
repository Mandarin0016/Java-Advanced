package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<String>();
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("END")){
            switch (command[0]){
                case "Add":
                    list.add(command[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(command[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(command[1]));
                    break;
                case "Swap":
                    int indexOne = Integer.parseInt(command[1]);
                    int indexTwo = Integer.parseInt(command[2]);
                    list.swap(indexOne, indexTwo);
                    break;
                case "Greater":
                    System.out.println(list.greater(command[1]));
                    break;
                case "Max":
                    System.out.println(list.max());
                    break;
                case "Min":
                    System.out.println(list.min());
                    break;
                case "Print":
                    list.print();
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }
    }
}
