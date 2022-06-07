package Google;

public class Parent {
    private String parentName;
    private String parentBirthday;

    public Parent(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }
    @Override
    public String toString(){
        return String.format("%s %s", getParentName(), getParentBirthday());
    }

    public String getParentName() {
        return parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
    public String getParentBirthday() {
        return parentBirthday;
    }
    public void setParentBirthday(String parentBirthday) {
        this.parentBirthday = parentBirthday;
    }
}
