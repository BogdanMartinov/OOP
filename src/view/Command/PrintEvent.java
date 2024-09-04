package view.Command;

import view.ConsoleUI;

public class PrintEvent extends Command {
    public PrintEvent(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Вывести изменений";
    }

    @Override
    public void execute() {
        consoleUI.PrintCurrentEvent();
    }
}