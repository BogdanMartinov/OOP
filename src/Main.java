import writer.FileHandler;
import writer.Writer;

import FamilyTree.FamilyTree;
import FamilyTree.Gender;
import FamilyTree.Human;
import writer.FileHandler;
import writer.Writer;
import Sort.Sorter;

import java.time.LocalDate;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = createFamilyTree();

        // Сохранение дерева в файл
        saveTree(familyTree);
        familyTree.save("src/writer/tree.txt");

        // Чтение дерева из файла
        FamilyTree loadedTree = readTree();
        loadedTree = FamilyTree.read("src/writer/tree.txt");

        // Сортировка и вывод по имени
        Sorter.sortByName(loadedTree.getPeople());
        System.out.println("Сортировка по имени:");
        printFamilyTree(loadedTree);
        // Сортировка и вывод по дате рождения
        Sorter.sortByBirthDate(loadedTree.getPeople());
        System.out.println("Сортировка по дате рождения:");
        printFamilyTree(loadedTree);
    }

    private static FamilyTree readTree() {
        Writer fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }

    private static void saveTree(FamilyTree tree) {
        Writer fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    private static FamilyTree createFamilyTree() {
        FamilyTree familyTree = new FamilyTree();

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
    private static void printFamilyTree(FamilyTree familyTree) {
        for (Human person : familyTree) {
            printHumanDetails(person);
        }
    }
    private static void printHumanDetails(Human human) {
        System.out.print(human.getName() + ", Дата Рождения: " + human.getBirthDate());
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