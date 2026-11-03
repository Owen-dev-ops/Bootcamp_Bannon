// Contains all constant variables for SwiftTally

package swifttally;

import java.time.format.DateTimeFormatter;

public class Constants {
    // No instances of this class should be made
    private Constants(){}

    /* Constant variables */

    // Formats dates
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TF = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Allows for bolding of words displayed in terminal
    public static final String BOLD = "\u001B[1m";
    public static final String RESET = " \u001B[0m";
}
