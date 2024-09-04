package view.Command;

import view.ConsoleUI;

public class PrintFamilyTreeHuman extends Command {
    public PrintFamilyTreeHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести генеалогическое древо человека";
    }

    @Override
    public void execute() {
        consoleUI.PrintFamilyTreeHuman();
    }
}