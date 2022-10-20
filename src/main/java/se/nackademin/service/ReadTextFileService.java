package se.nackademin.service;

import se.nackademin.model.Member;
import se.nackademin.utils.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ReadTextFileService {

    public static List<Member> convertCustomerFileToMemberList(Path filePath) {
        List<Member> members = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String firstLine, secondLine;
            while (!StringUtils.isNullOrEmpty(firstLine = br.readLine())) {
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
        if (StringUtils.isNullOrEmpty(firstLine, secondLine)) {
            return null;
        }
        List<String> nameAndSsn = StringUtils.splitNameAndPersonalNumber(firstLine);
        return new Member(nameAndSsn.get(0), nameAndSsn.get(1), LocalDate.parse(secondLine.trim()));
    }

}
