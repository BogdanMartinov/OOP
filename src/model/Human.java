package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human extends FamilyMember implements Comparable<Human> {
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private LocalDate deathDate;
    private List<Human> children;
    private List<Human> parents;

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public List<Human> getParents() {
        return parents;
    }

    public void addParent(Human parent) {
        parents.add(parent);
    }

    @Override
    public int compareTo(Human other) {
        return this.name.compareTo(other.name);
    }

    public boolean isAlive() {
        return deathDate == null;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthDate.getYear();
        if (today.getMonthValue() < birthDate.getMonthValue() || (today.getMonthValue() == birthDate.getMonthValue() && today.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }
        return age;
    }
}
