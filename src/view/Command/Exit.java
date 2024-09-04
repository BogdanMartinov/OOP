package view.Command;

import view.ConsoleUI;

public class Exit extends Command {
    public Exit(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Выход";
    }

    @Override
    public void execute() {
        this.consoleUI.Exit();
    }
}