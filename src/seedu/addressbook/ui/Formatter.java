package seedu.addressbook.ui;

import java.util.List;

/**
 * Format text for the application
 */
public class Formatter {

    /**
     * A decorative prefix added to the beginning of lines printed by AddressBook
     */
    private static final String LINE_PREFIX = "|| ";

    static final String DIVIDER = "===================================================";

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    /**
     * Offset required to convert between 1-indexing and 0-indexing.
     */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /**
     * A platform independent line separator.
     */
    private static final String LS = System.lineSeparator();

    /**
     * Format of indexed list item
     */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    static boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

    /**
     * Format mesasage(s) to user.
     *
     * @param message Messages that is going to be concatenated.
     * @return A formatted message to user.
     */
    static String formatMessageToUser(String... message) {
        StringBuilder fullMessage = new StringBuilder();
        for (String m : message) {
            fullMessage.append(LINE_PREFIX).append(m.replace("\n", LS + LINE_PREFIX)).append("\n");
        }
        return fullMessage.toString();
    }

    /**
     * Format command message to user.
     *
     * @param commandMessage Message for the command
     * @return A formatted command message to user.
     */
    static String formatCommandMessageToUser(String commandMessage) {
        return new StringBuilder().append(LINE_PREFIX).append(commandMessage).toString();
    }

    /**
     * Formats a list of strings as a viewable indexed list.
     */
    static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(Formatter.getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

}
