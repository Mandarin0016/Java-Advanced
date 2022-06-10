import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(firstLine).forEach(tasks::push);
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(secondLine).forEach(threads::offer);
        int endTask = Integer.parseInt(scanner.nextLine());
        boolean isEndTaskFound = false;
        while (!isEndTaskFound){
            int thread = threads.poll();
            int task = tasks.pop();
            if (task == endTask){
                threads.push(thread);
                isEndTaskFound = true;
                System.out.printf("Thread with value %d killed task %d%n", thread, endTask);
            }else {
                if (thread < task){
                    tasks.push(task);
                }
            }
        }
        while (!threads.isEmpty()){
            System.out.print(threads.poll() + " ");
        }
    }
}
