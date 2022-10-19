package se.nackademin.utils;

import se.nackademin.model.Member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ReadTextFile {

    public static List<Member> convertCustomerFileToMemberList(Path filePath) {
        List<Member> members = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String firstLine, secondLine;
            while ((firstLine = br.readLine()) != null) {
                secondLine = br.readLine();
                members.add(createMember(firstLine, secondLine));
            }
            br.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not exist");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Problem with IO");
            e.printStackTrace();
        }
        return members;
    }

    private static Member createMember(String firstLine, String secondLine) {
        return (Strings.isNotNullAndEmpty(firstLine, secondLine)) ?
                new Member(Strings.splitNameAndPersonalNumber(firstLine).get(0),
                        Strings.splitNameAndPersonalNumber(firstLine).get(1), LocalDate.parse(secondLine.trim())):
         null;
    }

}
