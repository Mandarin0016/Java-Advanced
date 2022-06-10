package ArrayCreator;

public class Main {
    public static void main(String[] args) {
        String[] myStringArray = ArrayCreator.create(5, "Pesho");
        Integer[] myIntegerArray = ArrayCreator.create(Integer.class, 5, 12);
        System.out.println();
    }
}
