package StrategyPattern;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        setAge(age);
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("You can not have person with negative age!");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }
}
