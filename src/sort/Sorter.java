package sort;

import model.FamilyMember;
import model.Human;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {

    public static <T extends FamilyMember> void sortByName(List<T> members) {
        Collections.sort(members, new FamilyMemberNameComparator<>());
    }

    public static void sortHumansByName(List<Human> humans) {
        Collections.sort(humans, Comparator.comparing(Human::getName));
    }

    public static void sortByBirthDate(List<Human> humans) {
        Collections.sort(humans, new HumanBirthDateComparator());
        Collections.sort(humans, Comparator.comparing(Human::getBirthDate));
    }
}
