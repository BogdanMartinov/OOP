package view.Command;

import view.ConsoleUI;

public class SetParrent extends Command{

    public SetParrent(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Установить родителей";
    }

    @Override
    public void execute() {
        consoleUI.SetParent();
    }
}