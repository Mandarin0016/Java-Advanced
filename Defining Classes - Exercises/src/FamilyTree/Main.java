package FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String initialInput = scanner.nextLine();
        List<String> parentChild = new ArrayList<>();
        Map<String, String> bornOn = new LinkedHashMap<>();
        List<Person> allPeople = new ArrayList<>();
        String data = scanner.nextLine();
        while (!data.equals("End")) {
            if (data.contains(" - ")) {
                parentChild.add(data);
            } else {
                String[] tokens = data.split("\\s+");
                String date = tokens[tokens.length - 1];
                String name = data.replace(" " + date, "");
                bornOn.put(name, date);
            }
            data = scanner.nextLine();
        }
        Person person;
        if (initialInput.contains("/")) {
            person = new Person();
            person.setDateOfBirth(initialInput);
            for (Map.Entry<String, String> entry : bornOn.entrySet()) {
                if (entry.getValue().equals(person.getDateOfBirth())){
                    person.setName(entry.getKey());
                }
            }
        } else {
            person = new Person();
            person.setName(initialInput);
            person.setDateOfBirth(bornOn.get(person.getName()));
        }
        FamilyTree myFamilyTree = new FamilyTree();
        myFamilyTree.setMe(person);
        for (String entryParentChild : parentChild) {
            String parent = entryParentChild.split(" - ")[0];
            String child = entryParentChild.split(" - ")[1];
            if (child.equals(person.getName()) || child.equals(person.getDateOfBirth())) {
                Person foundParent = new Person();
                boolean parentIsAlreadyExisting = false;
                if (parent.contains("/")) {
                    foundParent.setDateOfBirth(parent);
                    for (Map.Entry<String, String> entry : bornOn.entrySet()) {
                        if (entry.getValue().equals(foundParent.getDateOfBirth())){
                            foundParent.setName(entry.getKey());
                            break;
                        }
                    }
                } else {
                    foundParent.setName(parent);
                    foundParent.setDateOfBirth(bornOn.get(foundParent.getName()));
                }
                if (myFamilyTree.getParents().isEmpty()){
                    myFamilyTree.getParents().add(foundParent);
                    allPeople.add(foundParent);
                }else {
                    for (Person currentPerson : allPeople) {
                        if (currentPerson.getName().equals(foundParent.getName()) && currentPerson.getDateOfBirth().equals(foundParent.getDateOfBirth())) {
                            parentIsAlreadyExisting = true;
                            break;
                        }
                    }
                    if (!parentIsAlreadyExisting){
                        myFamilyTree.getParents().add(foundParent);
                        allPeople.add(foundParent);
                    }
                }
            }
        }

        for (String entryParentChild : parentChild) {
            String parent = entryParentChild.split(" - ")[0];
            String child = entryParentChild.split(" - ")[1];
            if (parent.equals(myFamilyTree.getMe().getName()) || parent.equals(myFamilyTree.getMe().getDateOfBirth())){
                Person childFound = new Person();
                boolean isPersonAlreadyExisting = false;
                if (child.contains("/")){
                    childFound.setDateOfBirth(child);
                    for (Map.Entry<String, String> findName : bornOn.entrySet()) {
                        if (findName.getValue().equals(childFound.getDateOfBirth())){
                            childFound.setName(findName.getKey());
                            break;
                        }
                    }
                }else {
                    childFound.setName(child);
                    childFound.setDateOfBirth(bornOn.get(childFound.getName()));
                }
                if (myFamilyTree.getChildren().isEmpty()){
                    myFamilyTree.getChildren().add(childFound);
                    allPeople.add(childFound);
                }else {
                    for (Person currentPerson : allPeople) {
                        if (currentPerson.getName().equals(childFound.getName()) && currentPerson.getDateOfBirth().equals(childFound.getDateOfBirth())){
                            isPersonAlreadyExisting = true;
                            break;
                        }
                    }
                    if (!isPersonAlreadyExisting){
                        myFamilyTree.getChildren().add(childFound);
                        allPeople.add(childFound);
                    }
                }
            }
        }
        System.out.println(myFamilyTree);
    }
}
