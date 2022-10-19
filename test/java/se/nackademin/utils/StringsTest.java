package se.nackademin.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    @ParameterizedTest
    @NullAndEmptySource
    void should_return_false_if_String_is_empty_or_null(String input) {
        boolean actual = Strings.isNotNullAndEmpty(input);

        assertFalse(actual);
    }

    @Test
    void should_return_true_id_String_is_not_empty_or_null() {
        boolean actual = Strings.isNotNullAndEmpty("input");

        assertTrue(actual);
    }

    @Test
    void should_return_true_if_all_strings_are_not_empty_or_null(){
        boolean actual = Strings.isNotNullAndEmpty("bahar", "java", "ackademin", "null");

        assertTrue(actual);
    }

    @Test
    void should_return_false_if_one_string_is_empty_or_null(){
        boolean actual = Strings.isNotNullAndEmpty("bahar", "java", "", null);

        assertFalse(actual);
    }

    @Test
    void should_split_correctly() {
        String input= "7703021234  , Alhambra Aromes   ";
        List<String> list = Strings.splitNameAndPersonalNumber(input);

        assertEquals("Alhambra Aromes", list.get(0));
        assertEquals("7703021234", list.get(1));
    }
}