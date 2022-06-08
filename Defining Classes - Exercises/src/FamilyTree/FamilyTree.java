package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private Person me;
    private List<Person> parents = new ArrayList<>();
    private List<Person> children = new ArrayList<>();

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(getMe());
        output.append("Parents: ").append(System.lineSeparator());
        getParents().forEach(output::append);
        output.append("Children: ").append(System.lineSeparator());
        getChildren().forEach(output::append);
        return output.toString();
    }
    public Person getMe() {
        return me;
    }
    public void setMe(Person me) {
        this.me = me;
    }
    public List<Person> getParents() {
        return parents;
    }
    public void setParents(List<Person> parents) {
        this.parents = parents;
    }
    public List<Person> getChildren() {
        return children;
    }
    public void setChildren(List<Person> children) {
        this.children = children;
    }
}
