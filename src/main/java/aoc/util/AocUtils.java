package aoc.util;

public final class AocUtils {

    public final static String DEFAULT_FILENAME = "input.txt";
    
    public static String readInput(String filename) {
        if(filename == null)
        {
            filename = DEFAULT_FILENAME;
        }
        return "";
    }
}
