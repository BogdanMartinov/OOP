package view.Command;

import view.ConsoleUI;

public class SetCurrentFamilyTree extends Command{
    public SetCurrentFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Установить текущее генеалогическое древо";
    }
    @Override
    public void execute() {
        consoleUI.SetCurrentFamilyTree();

    }
}