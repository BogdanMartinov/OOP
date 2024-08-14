package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyMember> implements Iterable<T>, Serializable {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        if (member != null) {
            this.members.add(member);
        }
    }

    public List<T> getMembers() {
        return members;
    }

    public List<T> getPeople() {
        return members;
    }

    public List<T> getChildrenOf(T member) {
        if (member != null) {
            return (List<T>) member.getChildren();
        }
        return new ArrayList<>();
    }

    public T findMemberByName(String name) {
        if (name != null) {
            for (T member : members) {
                if (member.getName().equals(name)) {
                    return member;
                }
            }
        }
        return null;
    }

    public List<T> getParentsOf(T member) {
        if (member != null) {
            return (List<T>) member.getParents();
        }
        return new ArrayList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void save(String filePath) {
        Writer fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        try {
            fileHandler.save(this);
        } catch (Exception e) {
            System.err.println("Ошибка при сохранении генеалогического древа: " + e.getMessage());
        }
    }

    public static <T extends FamilyMember> FamilyTree<T> read(String filePath) {
        Writer fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        try {
            return (FamilyTree<T>) fileHandler.read();
        } catch (Exception e) {
            System.err.println("Ошибка при чтении генеалогического древа: " + e.getMessage());
            return new FamilyTree<>();
        }
    }
}