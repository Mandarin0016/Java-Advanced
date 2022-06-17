package ComparingObjects;

public class Person implements Comparable<Person>{
    private int age;
    private String name;
    private String town;

    public Person(String name, int age, String town) {
        this.age = age;
        this.name = name;
        this.town = town;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        int result = this.getName().compareTo(o.getName());
        if (result == 0){
            result = Integer.compare(this.age, o.getAge());
            if (result == 0){
                result = this.town.compareTo(o.getTown());
            }
        }
        return result;
    }
}
