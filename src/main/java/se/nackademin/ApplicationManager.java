package se.nackademin;

import se.nackademin.exceptions.SeveralNameExistException;
import se.nackademin.model.Member;
import se.nackademin.model.MembershipType;
import se.nackademin.service.ObjectReaderService;
import se.nackademin.service.ObjectWriterService;
import se.nackademin.service.ReadTextFileService;
import se.nackademin.service.MemberListsService;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class ApplicationManager {

    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/customers.txt";
    private static final String COACH_FILE_PATH = "src/main/resources/coach.ser";
    private static final List<Member> members = ReadTextFileService.convertCustomerFileToMemberList(Path.of(CUSTOMERS_FILE_PATH));

    public void runApplication() throws IOException {

        FileOutputStream fos = new FileOutputStream(COACH_FILE_PATH);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Input name/personal number.\nClick on cancel for exit. ");
            if (input == null) {
                System.out.println("The coach file content is:");
                for (Member m : ObjectReaderService.readSerFileAndPutToList(COACH_FILE_PATH)) {
                    System.out.println(m);
                }
                fos.close();
                oos.close();
                break;
            }
            try {
                //for reception
                MembershipType type = MemberListsService.showMembershipStatus(members, input);
                System.out.println("Hi, " + input + " Your registration is: " + type);
                //for trainer
                if (MembershipType.ACTIVE.equals(type)) {
                    Member m = MemberListsService.getMember(members, input);
                    Member member = new Member(m.getName(), m.getPersonalNumber(), LocalDate.now());
                    ObjectWriterService.WriteNewMember(oos, member);
                }
            } catch (SeveralNameExistException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}