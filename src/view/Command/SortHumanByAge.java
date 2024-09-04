package view.Command;

import view.ConsoleUI;

public class SortHumanByAge extends Command{
    public SortHumanByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать людей по возрасту";
    }
    @Override
    public void execute() {
        consoleUI.SortHumanByAge();
    }
}