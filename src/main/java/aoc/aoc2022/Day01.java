package aoc.aoc2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import aoc.AocPuzzle;

public class Day01 implements AocPuzzle {

    @Override
    public int getYear() {
        return 2022;
    }

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public String runPart1(String input) {
        Integer max = Arrays.asList(input.split("\n\n")).stream()
                .map(elf -> {
                    return Arrays.asList(elf.split("\n")).stream()
                            .map(calorie -> Integer.parseInt(calorie))
                            .reduce(0, (subtotal, element) -> subtotal + element);
                })
                .max(Integer::compare)
                .orElse(0);
        return Integer.toString(max);
    }

    @Override
    public String runPart2(String input) {
        Integer max = Arrays.asList(input.split("\n\n")).stream()
                .map(elf -> {
                    return Arrays.asList(elf.split("\n")).stream()
                            .map(calorie -> Integer.parseInt(calorie))
                            .reduce(0, (subtotal, element) -> subtotal + element);
                })
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(0, (subtotal, element) -> subtotal + element);
        return Integer.toString(max);
    }
}
