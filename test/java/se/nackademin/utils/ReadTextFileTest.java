package se.nackademin.utils;

import org.junit.jupiter.api.Test;
import se.nackademin.model.Member;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReadTextFileTest {

    @Test
    void should_return_a_Member_list_from_txt_file() {
        Path p = Paths.get("test/resources/test.txt");

        List<Member> lines = ReadTextFile.convertCustomerFileToMemberList(p);
        assertNotNull(lines);
        assertEquals(14,lines.size());
        assertEquals("Mitsuko Mayotte",lines.get(12).getName());
        assertEquals(LocalDate.of(2019,12,22),lines.get(12).getRegistrationDate());
    }

    @Test
    void should_write_in_file() {

    }
}