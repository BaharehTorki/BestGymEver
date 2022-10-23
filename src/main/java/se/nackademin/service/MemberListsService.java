package se.nackademin.service;

import se.nackademin.exceptions.SeveralNameExistException;
import se.nackademin.model.Member;
import se.nackademin.model.MembershipType;
import se.nackademin.utils.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberListsService {

    public static Member getMember(List<Member> members, String input) throws SeveralNameExistException {
        if (StringUtils.isNullOrEmpty(input))
            return null;

        if (StringUtils.isSsn(input))
            return getMemberBySsn(members, input);

        return getMemberByName(members, input);
    }

    public static MembershipType showMembershipStatus(List<Member> members, String input) throws SeveralNameExistException {
        Member m = getMember(members, input);
        if (m == null || input == null) {
            return MembershipType.INVALID;
        }

        return (m.getRegistrationDate().isAfter(LocalDate.now().minusYears(1))) ?
                MembershipType.ACTIVE :
                MembershipType.INACTIVE;
    }

    private static Member getMemberByName(List<Member> members, String input) throws SeveralNameExistException {
        int count = 0;
        for (Member me : members) {
            if (input.equalsIgnoreCase(me.getName())) {
                count++;
            }
        }
        if (count > 1) {
            throw new SeveralNameExistException("There are more then one name exist, please search with Personal number.");
        }
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(input))
                return member;
        }
        return null;
    }

    private static Member getMemberBySsn(List<Member> members, String input) {
        for (Member member : members) {
            if (member.getPersonalNumber().equalsIgnoreCase(input))
                return member;
        }
        return null;
    }

//____________________________________________________________________________________________

    private static void getMemberByCorrectPersonalNumber(List<Member> members, String input) {
        if (StringUtils.isNullOrEmpty(input)) {
            System.out.println("input is null");
        }
    }

    private static boolean lengthOfPersonalNumber(List<Member> members, String input) {
        input.trim();
        if (input.length() == 12) {
            boolean a = input.startsWith("19") || input.startsWith("20");
            System.out.println(input);
            return true;
        }
        if (input.length() == 10) {
            if (input.startsWith("0")) {
                System.out.println("Your input is not correct");
                return false;
            } else {
                System.out.println(input);
            }
        }
        return true;
    }

    private static boolean differentTypeOfPersonalNumberScript(List<Member> members, String input) {
        input.trim();
        if (input.contains("-") || (input.contains("_"))) {
            return true;
        }
        return true;
    }

    private static boolean firstNameAndLAstName(List<Member> members, String input) {
        if (input.contains(" ")) {
            return true;
        } else
            return false;
    }

    private static boolean stringAndNumber(String input) {
        try{
            System.out.println("please enter your name");
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            s.trim();

            if (s.contains("123456789abcdefghijklmnopqrstuvwxyz")){
                System.out.println("You have typed combination of letters and numbers");
                return false;
            }
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return false;
    }

    private static boolean stringAndNumber1(List<Member> members, String input) {
        String s1 = "123456789abcdefghijklmnopqrstuvwxyz";
        //String s2 = "abcdefghijklmnopqrstuvwxyz";
        //boolean isNumber = Character.isDigit(input.charAt(i));

        if (input.contains(s1)) {
            try {
                System.out.println("Please write just by number or letters");
                Scanner scan = new Scanner(System.in);
                String input1 = scan.nextLine();
                //int number = Integer.parseInt(s1);

            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                System.out.println("You have typed combination of letters and numbers");
            }
        }
        return false;
    }
}

