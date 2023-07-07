package aoc;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import aoc.aoc2022.Day01;

/**
 * Hello world!
 *
 */
public class App {
    private static final int FIRST_AOC_YEAR = 2015;

    private static final int NUMBER_OF_AOC_DAYS = 25;

    private static final boolean RUN_TESTS = true;

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        int currentYear = calendar.get(Calendar.YEAR);

        for (int i = FIRST_AOC_YEAR; i <= currentYear; i++) {
            for (int j = 1; j <= NUMBER_OF_AOC_DAYS; j++) {
                String dayString = StringUtils.leftPad(Integer.toString(j), 2, "0");
                try {
                    String className = "aoc.aoc" + i + ".Day" + dayString;
                    AocPuzzle puzzle = (AocPuzzle) Class.forName(className).getDeclaredConstructor().newInstance();

                    System.out.println("Running AOC for " + i + " Day " + dayString);
                    if (RUN_TESTS) {
                        String testInputFilename = i + "/day" + dayString + "-input-test.txt";
                        InputStream inputStream = App.class.getClassLoader().getResourceAsStream(testInputFilename);
                        String testInput = IOUtils.toString(inputStream, Charset.defaultCharset());

                        long startTime1 = System.currentTimeMillis();
                        String result1 = puzzle.runPart1(testInput);
                        long endTime1 = System.currentTimeMillis();

                        long startTime2 = System.currentTimeMillis();
                        String result2 = puzzle.runPart2(testInput);
                        long endTime2 = System.currentTimeMillis();
                        System.out.println("Result for test:\t\t" + i + " day " + dayString + ":\tPart 1: " + result1 + "\ttime: "
                                + (endTime1 - startTime1) + "ms\t\tPart 2: " + result2 + "\ttime: "
                                + (endTime2 - startTime2) + "ms");
                    }

                    String finalInputFilename = i + "/day" + dayString + "-input.txt";
                    InputStream inputStream = App.class.getClassLoader().getResourceAsStream(finalInputFilename);
                    String finalInput = IOUtils.toString(inputStream, Charset.defaultCharset());
                    long startTime1 = System.currentTimeMillis();
                    String result1 = puzzle.runPart1(finalInput);
                    long endTime1 = System.currentTimeMillis();

                    long startTime2 = System.currentTimeMillis();
                    String result2 = puzzle.runPart2(finalInput);
                    long endTime2 = System.currentTimeMillis();

                    System.out.println("Result for input:\t\t" + i + " day " + dayString + ":\tPart 1: " + result1 + "\ttime: "
                            + (endTime1 - startTime1) + "ms\t\tPart 2: " + result2 + "\ttime: " + (endTime2 - startTime2)
                            + "ms");

                } catch (Exception e) {
                    if (!ClassNotFoundException.class.isInstance(e)) {
                        System.err.println(e);
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
