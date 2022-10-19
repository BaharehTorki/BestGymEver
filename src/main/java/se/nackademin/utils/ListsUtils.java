package se.nackademin.utils;

import se.nackademin.model.Member;
import se.nackademin.model.MembershipType;

import java.time.LocalDate;
import java.util.List;

public class ListsUtils {

    private List<Member> members;

    public static MembershipType getMembershipType(List<Member> members, String input) {
        if (Strings.isNullOrEmpty(input))
            return MembershipType.INVALID;

        if (Strings.isSsn(input))
            return getMembershipTypeBySsn(members, input);

        return getMembershipTypeByName(members, input);
    }

    private static MembershipType getMembershipTypeByName(List<Member> members, String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name))
                return (member.getRegistrationDate().isAfter(LocalDate.now().minusYears(1))) ?
                        MembershipType.ACTIVE :
                        MembershipType.INACTIVE;
        }
        return MembershipType.INVALID;
    }

    private static MembershipType getMembershipTypeBySsn(List<Member> members, String ssn) {
        for (Member member : members) {
            if (member.getPersonalNumber().equalsIgnoreCase(ssn))
                return (LocalDate.now().minusYears(1L).isBefore(member.getRegistrationDate())) ?
                        MembershipType.INACTIVE :
                        MembershipType.ACTIVE;
        }
        return MembershipType.INVALID;
    }
}
