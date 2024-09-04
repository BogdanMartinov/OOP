package view.Command;

import view.ConsoleUI;

public class SortHumanByName extends Command {
    public SortHumanByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать людей по имени";
    }

    @Override
    public void execute() {
        consoleUI.SortHumanByName();
    }
}