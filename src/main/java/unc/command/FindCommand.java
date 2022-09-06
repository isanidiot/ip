package unc.command;

import unc.Storage;
import unc.TaskList;
import unc.Ui;
import unc.UncException;

/**
 * Command that finds tasks containing a keyword when executed.
 */
public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String input) {
        this.keyword = input;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws UncException {
        TaskList foundList = taskList.find(keyword);
        ui.displayFoundList(foundList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
