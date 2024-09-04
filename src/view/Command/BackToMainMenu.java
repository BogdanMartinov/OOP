package view.Command;

import view.ConsoleUI;

public class BackToMainMenu extends Command {
    public BackToMainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Вернуться в главное меню";
    }

    @Override
    public void execute() {
        consoleUI.BackToMainMenu();
    }
}