package StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomStack customStack = new CustomStack();
        String[] initialValues = sc.nextLine().split(",\\s+");

        customStack.push(Integer.parseInt(initialValues[0].split("\\s+")[1]));
        for (int i = 1; i < initialValues.length; i++) {
            customStack.push(Integer.parseInt(initialValues[i].trim()));
        }

        String line = sc.nextLine();

        while (!"END".equals(line)) {
            if (line.equals("Pop")) {
                try {
                    customStack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }

            } else if (line.contains("Push")) {
                customStack.push(Integer.parseInt(line.split("\\s+")[1]));

            }

            line = sc.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer element : customStack) {
                System.out.println(element);
            }
        }
    }
}