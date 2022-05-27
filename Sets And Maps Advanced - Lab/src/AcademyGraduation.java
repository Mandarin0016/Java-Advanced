import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
            studentMap.put(name, grades);
        }
        for (Map.Entry<String, List<Double>> student : studentMap.entrySet()) {
            double averageScore = getAverage(student.getValue());
            System.out.printf("%s is graduated with ", student.getKey());
            System.out.println(averageScore);
        }
    }

    private static double getAverage(List<Double> value) {
        double sum = 0;
        for (Double aDouble : value) {
            sum += aDouble;
        }
        return sum / value.size();
    }
}
