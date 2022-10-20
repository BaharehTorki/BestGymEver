package se.nackademin;

import se.nackademin.exceptions.SeveralNameExistException;
import se.nackademin.model.Member;
import se.nackademin.model.MembershipType;
import se.nackademin.service.WriteOnSerFileService;
import se.nackademin.utils.ListsUtils;
import se.nackademin.service.ReadTextFileService;

import javax.swing.*;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WriteOnSerFileService.write("azad.ser");
       /* MembershipType type = null;
        List<Member> members = ReadTextFileService.convertCustomerFileToMemberList(Paths.get("src/main/resources/customers.txt"));

        while (true) {
            String input = JOptionPane.showInputDialog(null, "Input name/personal number:");
            try {
                type = ListsUtils.getMembershipType(members, input);
                System.out.println("Your registration is: "+ type);
            } catch (SeveralNameExistException e) {
                System.out.println(e.getMessage());
            }
        }*/


    }

}
