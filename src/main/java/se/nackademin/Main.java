package se.nackademin;

import se.nackademin.model.Member;
import se.nackademin.model.MembershipType;
import se.nackademin.utils.ListsUtils;
import se.nackademin.utils.ReadTextFile;
import se.nackademin.utils.Strings;

import javax.swing.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog(null, "Input name/personal number:");
        if (Strings.isNullOrEmpty(input))
            System.out.println("input " + input);

        List<Member> members = ReadTextFile.convertCustomerFileToMemberList(Paths.get("src/main/resources/customers.txt"));
        MembershipType type = ListsUtils.getMembershipType(members, input);
        System.out.println(type);


    }

}
