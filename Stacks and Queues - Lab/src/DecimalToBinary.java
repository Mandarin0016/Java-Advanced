import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();
        if (number == 0){
            binaryNumber.push(0);
        }
        while (number > 0){
            if (number % 2 == 1){
                binaryNumber.push(1);
            }else {
                binaryNumber.push(0);
            }
            number = number / 2;
        }
        binaryNumber.forEach(System.out::print);
    }
}