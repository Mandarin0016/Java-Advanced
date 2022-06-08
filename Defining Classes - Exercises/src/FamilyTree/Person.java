package FamilyTree;

public class Person {
    private String name = "";
    private String dateOfBirth = "";
    @Override
    public String toString(){
        return getName() + " " + getDateOfBirth() + System.lineSeparator();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
