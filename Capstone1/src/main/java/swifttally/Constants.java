// Contains all constant variables for SwiftTally

package swifttally;

import java.time.format.DateTimeFormatter;

public class Constants {
    // No instances of this class should be made
    private Constants(){}

    /* CONSTANT VARIABLES */

    /* Formats dates */
    // LocalDateTime formatter
    public static final DateTimeFormatter LDTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // LocalDateTime, only the year format
    public static final DateTimeFormatter LDTFY = DateTimeFormatter.ofPattern("yyyy");
    // LocalDateTime, only the month format
    public static final DateTimeFormatter LDTFM = DateTimeFormatter.ofPattern("MM");
    // LocalDateTime, only the day format
    public static final DateTimeFormatter LDTFD = DateTimeFormatter.ofPattern("dd");
    // LocalTime formatter
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH:mm:ss");


    /* Allows for bolding of words displayed in terminal */
    public static final String BOLD = "\u001B[1m";
    public static final String RESET = " \u001B[0m";
}
