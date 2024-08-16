package view;

import model.Human;

import java.util.List;

public interface FamilyTreeView {
    void displayHumanDetails(Human human);
    void displayMessage(String message);
    void displayHumanList(List<Human> humans);
}
