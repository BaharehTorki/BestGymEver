package se.nackademin.service;

import org.junit.jupiter.api.Test;
import se.nackademin.model.Member;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectReaderAndWriterServiceTest {

    @Test
    void should_add_and_read_from_file() throws IOException {
        String filePath = "test/resources/test.ser";
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        ObjectWriterService.WriteNewMember(oos, new Member("1", "1", LocalDate.now()));
        ObjectWriterService.WriteNewMember(oos, new Member("2", "2", LocalDate.now()));
        ObjectWriterService.WriteNewMember(oos, new Member("3", "3", LocalDate.now()));
        ObjectWriterService.WriteNewMember(oos, new Member("4", "4", LocalDate.now()));

        List<Member> actual = ObjectReaderService.readSerFileAndPutToList(filePath);

        assertEquals(4, actual.size());
    }
}