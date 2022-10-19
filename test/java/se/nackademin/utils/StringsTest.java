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
        boolean actual = Strings.isNullOrEmpty(input);

        assertTrue(actual);
    }

    @Test
    void should_return_true_id_String_is_not_empty_or_null() {
        boolean actual = Strings.isNullOrEmpty("input");

        assertFalse(actual);
    }

    @Test
    void should_return_false_if_none_strings_is_null_or_empty(){
        boolean actual = Strings.isNullOrEmpty("bahar", "java", "ackademin", "null");

        assertFalse(actual);
    }

    @Test
    void should_return_true_if_none_string_is_empty_or_null(){
        boolean actual = Strings.isNullOrEmpty("bahar", "java", "", null);

        assertTrue(actual);
    }

    @Test
    void should_split_correctly() {
        String input= "7703021234  , Alhambra Aromes   ";
        List<String> list = Strings.splitNameAndPersonalNumber(input);

        assertEquals("Alhambra Aromes", list.get(0));
        assertEquals("7703021234", list.get(1));
    }

    @Test
    void should_return_true_if_String_is_personal_number() {
        boolean actual = Strings.isSsn("8501151234");
        assertTrue(actual);
    }
    @Test
    void should_return_false_if_String_is_not_personal_number() {
        boolean actual = Strings.isSsn("8501151234aa");
        assertFalse(actual);
    }
}