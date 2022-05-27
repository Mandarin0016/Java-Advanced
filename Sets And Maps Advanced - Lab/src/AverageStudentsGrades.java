import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentsMap = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double grade = Double.parseDouble(data[1]);
            if (!studentsMap.containsKey(name)){
                studentsMap.put(name, new ArrayList<>());
            }
            studentsMap.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> student : studentsMap.entrySet()) {
            String name = student.getKey();
            double averageScore = getAverage(student.getValue());
            System.out.printf("%s -> ", name);
            student.getValue().forEach(aDouble -> System.out.printf("%.2f ", aDouble));
            System.out.printf("(avg: %.2f)%n", averageScore);
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
