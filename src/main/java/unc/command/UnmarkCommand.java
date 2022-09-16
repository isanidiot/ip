package unc.command;

import unc.Storage;
import unc.TaskList;
import unc.Ui;

/**
 * Command that marks a task as not done when executed.
 */
public class UnmarkCommand extends Command {
    private final int index;

    /**
     * Constructor.
     *
     * @param num Index of task as seen by user, not the actual index in ArrayList structure.
     */
    public UnmarkCommand(int num) {
        this.index = num - 1;
    }

    /**
     * Marks the task at given index as not done.
     *
     * @param taskList List to be operated on.
     * @param ui UI to print message.
     * @param storage Storage to save updated list.
     * @return the message to be shown by UI
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.markAsNotDone(index);
        storage.save(taskList);
        return ui.unmark(taskList, index);
    }

    /**
     * {@inheritDoc}
     *
     * @return false.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
