package view.Command;

import view.ConsoleUI;

public class PrintFamilyTreeEvent extends Command {
    public PrintFamilyTreeEvent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести события семейного древа";
    }

    @Override
    public void execute() {
        consoleUI.PrintFamilyTreeEvent();
    }
}