package Scale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> myScale = new Scale<>(5, 221);
        System.out.println(myScale.getHeavier());
    }
}
