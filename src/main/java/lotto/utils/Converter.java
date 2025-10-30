package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> toIntList(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(toInt(input));
        }
        return numbers;
    }
}
