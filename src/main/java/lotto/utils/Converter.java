package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> toIntList(String input) {
        String[] inputs = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String inputNumber : inputs) {
            numbers.add(toInt(inputNumber));
        }
        return numbers;
    }
}