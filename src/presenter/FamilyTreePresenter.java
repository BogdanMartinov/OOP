package presenter;

import model.FamilyTree;
import model.Human;
import model.Gender;
import sort.Sorter;
import view.FamilyTreeView;

import java.time.LocalDate; // Add this import statement
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void saveTree(String filePath) {
        familyTree.save(filePath);
        view.displayMessage("Family tree saved to " + filePath);
    }

    public void loadTree(String filePath) {
        this.familyTree = FamilyTree.read(filePath);
        view.displayMessage("Family tree loaded from " + filePath);
    }

    public void displayHumanDetails(String name) {
        Human human = familyTree.findHumanByName(name);
        if (human != null) {
            view.displayHumanDetails(human);
        } else {
            view.displayMessage("Human not found.");
        }
    }

    public void sortAndDisplayByName() {
        Sorter.sortByName(familyTree.getPeople());
        view.displayMessage("Sorted by name:");
        view.displayHumanList(familyTree.getPeople());
    }

    public void sortAndDisplayByBirthDate() {
        Sorter.sortByBirthDate(familyTree.getPeople());
        view.displayMessage("Sorted by birth date:");
        view.displayHumanList(familyTree.getPeople());
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = new Human(name, birthDate, gender);
        familyTree.addMember(human);
        view.displayMessage("Human added: " + name);
    }

    public void createRelationship(String parentName, String childName) {
        Human parent = familyTree.findHumanByName(parentName);
        Human child = familyTree.findHumanByName(childName);
        if (parent != null && child != null) {
            parent.addChild(child);
            view.displayMessage("Relationship created: " + parentName + " is parent of " + childName);
        } else {
            view.displayMessage("Parent or child not found.");
        }
    }
}
