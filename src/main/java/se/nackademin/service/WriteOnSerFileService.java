package se.nackademin.service;

import se.nackademin.model.Member;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;

public class WriteOnSerFileService {

    public static void write(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(new Member("Azad", "123456878", LocalDate.now()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
