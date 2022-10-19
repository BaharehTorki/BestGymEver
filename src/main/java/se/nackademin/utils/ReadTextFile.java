package se.nackademin.utils;

import se.nackademin.model.Member;
import se.nackademin.model.MembershipType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.lang.Integer.parseInt;

public class ReadTextFile {

    public static List<Member> convertCustomerFileToMemberList(Path filePath) {
        List<Member> members = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String firstLine, secondLine;
            while (!Strings.isNullOrEmpty(firstLine = br.readLine())) {
                secondLine = br.readLine();
                members.add(createMember(firstLine, secondLine));
            }
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
        if (Strings.isNullOrEmpty(firstLine, secondLine)) {
            return null;
        }
        List<String> nameAndSsn = Strings.splitNameAndPersonalNumber(firstLine);
        return new Member(nameAndSsn.get(0), nameAndSsn.get(1), LocalDate.parse(secondLine.trim()));
    }

}
