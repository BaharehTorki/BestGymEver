package se.nackademin.utils;

import se.nackademin.exceptions.SeveralNameExistException;
import se.nackademin.model.Member;
import se.nackademin.model.MembershipType;

import java.time.LocalDate;
import java.util.List;

public class ListsUtils {

    private List<Member> members;

    public static MembershipType getMembershipType(List<Member> members, String input) throws SeveralNameExistException {
        if (StringUtils.isNullOrEmpty(input))
            return MembershipType.INVALID;

        if (StringUtils.isSsn(input))
            return getMembershipTypeBySsn(members, input);

        return getMembershipTypeByName(members, input);
    }

    private static MembershipType getMembershipTypeByName(List<Member> members, String name) throws SeveralNameExistException {
        int count = 0;
        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(name)) {
                count++;
            }
        }
        if (count > 1)
            throw new SeveralNameExistException("There are more then one name exist, please search with Personal number.");

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
                return (member.getRegistrationDate().isAfter(LocalDate.now().minusYears(1))) ?
                        MembershipType.ACTIVE :
                        MembershipType.INACTIVE;
        }
        return MembershipType.INVALID;
    }
}
