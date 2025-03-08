package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static boolean compareValues(String expected, String actual) {
        return compareValues(expected, actual, new ArrayList<>());
    }

    public static boolean compareValues(int expected, int actual) {
        return compareValues(String.valueOf(expected), String.valueOf(actual), new ArrayList<>());
    }

    private static boolean compareValues(String expected, String actual, List<CompareOptions> exceptOptions) {
        if (expected == null) {
            expected = "";
        }
        if (exceptOptions == null) {
            exceptOptions = new ArrayList<>();
        }
        actual = formatString(actual, exceptOptions);
        expected = formatString(expected, exceptOptions);
        if (!actual.equalsIgnoreCase(expected)) {
            System.out.println(("Differences in: actual[" + actual + "], expected[" + expected + "]"));
            return false;
        }
        return true;
    }

    private static String formatString(String text, List<CompareOptions> compareOptions) {
        if (compareOptions == null) {
            compareOptions = new ArrayList<>();
        }
        if (!compareOptions.contains(CompareOptions.TRIM)) {
            text = text.trim();
        }
        if (!compareOptions.contains(CompareOptions.IGNORE_CASE)) {
            text = text.toLowerCase();
        }
        if (!compareOptions.contains(CompareOptions.REMOVE_COMMA)) {
            text = text.replaceAll(",", " ");
        }
        if (!compareOptions.contains(CompareOptions.REMOVE_DOTS)) {
            text = text.replaceAll("\\.", "");
        }
        if (!compareOptions.contains(CompareOptions.REMOVE_ENTER)) {
            text = text.replaceAll("\\r+", " ")
                       .replaceAll("\\n+", " ");
        }
        if (!compareOptions.contains(CompareOptions.REMOVE_MULTIPLE_SPACES)) {
            text = text.replaceAll("\\s{2,}", " ");
        }
        if (!compareOptions.contains(CompareOptions.REPLACE_SPECIAL_SPACES)) {
            text = text.replaceAll(" ", "")
                       .replaceAll(" ", "");
        }
        if (!compareOptions.contains(CompareOptions.REMOVE_ALL_SPACES)) {
            text = text.replaceAll(" ", "");
        }
        if (!compareOptions.contains(CompareOptions.TO_LOWER_CASE)) {
            text = text.toLowerCase();
        }
        if (!compareOptions.contains(CompareOptions.CHANGE_COMMAS_TO_DOTS)) {
            text = text.replaceAll("[,]+", ".");
        }
        return text;
    }

    public static boolean compareArrays(String[] expected, String[] actual) {
        return compareArrays(expected, actual, new CompareOptions[] {});
    }

    public static boolean compareArrays(String[] expected, String[] actual, CompareOptions... exceptOptions) {
        if (expected.length != actual.length) {
            System.out.println("Lengths of arrays are not equal");
            return false;
        }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] == null)
                expected[i] = "";
            if (actual[i] == null)
                actual[i] = "";
            if (!compareValues(expected[i], actual[i], Arrays.stream(exceptOptions)
                                                             .collect(Collectors.toList()))) {
                return false;
            }
        }
        return true;
    }

    public enum CompareOptions {
        IGNORE_CASE,
        REMOVE_COMMA,
        REMOVE_ENTER,
        REMOVE_MULTIPLE_SPACES,
        REMOVE_ALL_SPACES,
        TRIM,
        TRANSLATE,
        REPLACE_SPECIAL_SPACES,
        REMOVE_DOTS,
        TO_LOWER_CASE,
        CHANGE_COMMAS_TO_DOTS,
    }

}
