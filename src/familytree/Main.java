package familytree;

import model.FamilyTree;
import model.Gender;
import model.Human;
import presenter.FamilyTreePresenter;
import sort.Sorter;
import writer.FileHandler;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FamilyTree<Human> familyTree = createFamilyTree();
        FamilyTreeView view = new FamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, view);

        presenter.addHuman("John", LocalDate.of(1990, 1, 1), Gender.MALE);
        presenter.addHuman("Jane", LocalDate.of(1995, 1, 1), Gender.FEMALE);
        presenter.addHuman("Alice", LocalDate.of(2020, 1, 1), Gender.FEMALE);

        presenter.createRelationship("John", "Alice");
        presenter.createRelationship("Jane", "Alice");

        presenter.displayHumanDetails("Alice");
        presenter.sortAndDisplayByName();
        presenter.sortAndDisplayByBirthDate();

        presenter.saveTree("family_tree.txt");
        presenter.loadTree("family_tree.txt");

        // Сохранение дерева в файл
        saveTree(familyTree);

        // Чтение дерева из файла
        FamilyTree<Human> loadedTree = readTree();

        // Сортировка и вывод по имени
        Sorter.sortByName(loadedTree.getPeople());
        System.out.println("Сортировка по имени:");
        printFamilyTree(loadedTree);

        // Сортировка и вывод по дате рождения
        Sorter.sortByBirthDate(loadedTree.getPeople());
        System.out.println("Сортировка по дате рождения:");
        printFamilyTree(loadedTree);

        FileHandler fileHandler = new FileHandler();

        // Create a sample FamilyTree object
        FamilyTree<Human> sampleFamilyTree = new FamilyTree<>();
        // Add some humans to the tree...

        // Save the family tree to a file
        fileHandler.save(sampleFamilyTree);

        // Read the family tree from the file
        FamilyTree<Human> loadedSampleTree = (FamilyTree<Human>) fileHandler.read();

        if (loadedSampleTree != null) {
            System.out.println("Sample family tree loaded successfully.");
        } else {
            System.out.println("Failed to load sample family tree.");
        }
    }

    private static FamilyTree<Human> createFamilyTree() {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        Human ivan = new Human("Иван", LocalDate.of(1974, 6, 1), Gender.MALE);
        Human maria = new Human("Мария", LocalDate.of(1979, 8, 15), Gender.FEMALE);
        Human mikhail = new Human("Михаил", LocalDate.of(2004, 11, 30), Gender.MALE);
        Human anna = new Human("Анна", LocalDate.of(2006, 5, 25), Gender.FEMALE);
        // Устанавливаем дату смерти (для демонстрации)
        maria.setDeathDate(LocalDate.of(2023, 4, 10));
        ivan.addChild(mikhail);
        ivan.addChild(anna);

        familyTree.addHuman(ivan);
        familyTree.addHuman(maria);
        familyTree.addHuman(mikhail);
        familyTree.addHuman(anna);

        return familyTree;
    }

    private static void saveTree(FamilyTree tree) {
        Writer fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    private static FamilyTree<Human> readTree() {
        Writer fileHandler = new FileHandler();
        return (FamilyTree<Human>) fileHandler.read();
    }

    private static void printFamilyTree(FamilyTree<Human> familyTree) {
        for (Human person : familyTree.getPeople()) {
            printHumanDetails(person);
        }
    }

    private static void printHumanDetails(Human human) {
        System.out.print(human.getName() + ", Дата рождения: " + human.getBirthDate());
        if (human.isAlive()) {
            System.out.println(", Возраст: " + human.getAge());
        } else {
            System.out.println(", Дата смерти: " + human.getDeathDate() + ", Возраст: " + human.getAge());
        }
        List<Human> parents = human.getParents();
        if (!parents.isEmpty()) {
            System.out.print("Родители: ");
            for (Human parent : parents) {
                System.out.print(parent.getName() + " ");
            }
            System.out.println();
        }
    }
}