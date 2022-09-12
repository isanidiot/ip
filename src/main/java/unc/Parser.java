package unc;

import unc.command.Command;
import unc.command.DeadlineCommand;
import unc.command.DeleteCommand;
import unc.command.EventCommand;
import unc.command.ExitCommand;
import unc.command.FindCommand;
import unc.command.ListCommand;
import unc.command.MarkCommand;
import unc.command.TodoCommand;
import unc.command.UnmarkCommand;

/**
 * Class to create commands from input strings.
 */
public class Parser {
    private enum ValidInput {
        LIST,
        MARK,
        UNMARK,
        DELETE,
        TODO,
        DEADLINE,
        EVENT,
        BYE,
        FIND

    }

    /**
     * Reads the user input to translate to valid commands.
     *
     * @param input Entire line of user input.
     * @return Adequate command based on keyword.
     */
    public static Command parse(String input) {
        String[] words = input.split("\\s+", 2);
        ValidInput verb = ValidInput.valueOf(words[0].toUpperCase());
        switch (verb) {
        case LIST:
            return new ListCommand();
        case MARK:
            return new MarkCommand(Integer.parseInt(words[1]));
        case UNMARK:
            return new UnmarkCommand(Integer.parseInt(words[1]));
        case DELETE:
            return new DeleteCommand(Integer.parseInt(words[1]));
        case TODO:
            return new TodoCommand(words[1]);
        case DEADLINE:
            return new DeadlineCommand(words[1]);
        case EVENT:
            return new EventCommand(words[1]);
        case BYE:
            return new ExitCommand();
        case FIND:
            return new FindCommand(words[1]);
        default:
            throw new RuntimeException();
        }
    }
}
