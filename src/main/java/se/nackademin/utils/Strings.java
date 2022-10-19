package se.nackademin.utils;

import java.util.ArrayList;
import java.util.List;

public class Strings {

    public static boolean isNotNullAndEmpty(String string) {
        return string != null && !string.isEmpty();
    }

    public static boolean isNotNullAndEmpty(String... strings) {
        for (String s : strings) {
            if (!isNotNullAndEmpty(s))
                return false;
        }
        return true;
    }

    public static List<String> splitNameAndPersonalNumber(String string) {
        List<String> output = new ArrayList<>();

        String[] split = string.split(",");

        output.add(split[1].trim());
        output.add(split[0].trim());
        return output;
    }

}
