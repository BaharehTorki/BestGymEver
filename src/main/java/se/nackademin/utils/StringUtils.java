package se.nackademin.utils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

public class StringUtils {

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isNullOrEmpty(String... strings) {
        for (String s : strings) {
            if (isNullOrEmpty(s))
                return true;
        }
        return false;
    }

    public static List<String> splitNameAndPersonalNumber(String string) {
        List<String> output = new ArrayList<>();

        String[] split = string.split(",");

        output.add(split[1].trim());
        output.add(split[0].trim());
        return output;
    }
    public static boolean isName(String string){
        if (StringUtils.isNullOrEmpty(string))
            return false;
        try {
            parseLong(string);
            return false;
        }catch (Exception e){
            return true;
        }
    }
    public static boolean isSsn(String string){
        if (StringUtils.isNullOrEmpty(string))
            return false;
        try {
            parseLong(string);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
