package se.nackademin.utils;

import org.junit.jupiter.api.Test;
import se.nackademin.model.Member;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReadTextFileTest {

    @Test
    void should_return_a_string_list_of_file() {
        Path p = Paths.get("test/resources/test.txt");

        List<Member> lines = ReadTextFile.convertCustomerFileToMemberList(p);

        assertNotNull(lines);
        assertEquals(28,lines.size());

    }

    @Test
    void should_write_in_file() {

    }
}