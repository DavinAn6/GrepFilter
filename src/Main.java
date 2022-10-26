import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Grep class
 * @author Davin An
 * @version 1.0
 */
public class Main {

    /**
     * Grep method
     * 1. Read any files contained in directory and search each file for string
     * 2. Execute recursively
     * 3. Return string containing all matches from all files
     * @param file Directory to search in
     * @param regex String to search for
     * @param caseSensitive Where search should be case-sensitive
     * @return String containing all matches from all files
     */
    public static String grep(File file, String regex, boolean caseSensitive) throws FileNotFoundException {
        Scanner scan; // Scanner object to read file
        String testLine; // String to temporarily store each line in file
        String grepReturn = ""; // Return string
        int lineNum; // Line number in which target string is found

        if (regex.contains("\\n")) {
            throw new InvalidSearchStringException(regex + " contains new line character");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist");
        }

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) { // Recursive step : is a directory
                grepReturn = grepReturn + grep(f, regex, caseSensitive);
            } else { // Base case : is a file
                scan = new Scanner(f);
                lineNum = 1;
                while (scan.hasNext()) {
                    testLine = scan.nextLine();
                    if (caseSensitive) { // Search is case-sensitive
                        if (testLine.contains(regex)) {
                            grepReturn = grepReturn + (f.getPath() + ":" + lineNum + ":" + testLine + "\n");
                        }
                    } else { // Search is case-insensitive
                        if ((testLine.toLowerCase()).contains(regex.toLowerCase())) {
                            grepReturn = grepReturn + (f.getPath() + ":" + lineNum + ":" + testLine + "\n");
                        }
                    }
                    lineNum++;
                }
            }
        }
        return grepReturn;
    }

    /**
     * Main method
     * Command will be passed as argument to main method
     * Arguments will always be in the order of flag-string-directory
     * 1. Parse the command line arguments
     * 2. Call grep with the correct arguments
     * 3. Check number of arguments and throw IllegalArgumentException
     * 4. Catch any exceptions thrown by grep
     * 5. Print out the result of grep
     * @param args Console arguments
     */
    public static void main(String[] args) {
        File file;
        String regex;
        boolean caseSensitive;

        // Check argument for exceptions
        if ((args.length < 2) || ((args[0].contains("-i")) && (args.length < 3))) {
            throw new IllegalArgumentException("Not enough arguments");
        }

        caseSensitive = !(args[0].contains("-i"));
        if (caseSensitive) {
            regex = args[0];
            file = new File(args[1] + "/");
        } else {
            regex = args[1];
            file = new File(args[2] + "/");
        }

        // Call grep method and print results
        // Catch any exceptions thrown by grep
        try {
            System.out.println(grep(file, regex, caseSensitive));
        } catch (InvalidSearchStringException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}