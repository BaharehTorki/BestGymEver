package se.nackademin.service;

import se.nackademin.exceptions.SeveralNameExistException;
import se.nackademin.model.Member;
import se.nackademin.model.MembershipType;
import se.nackademin.utils.StringUtils;

import java.time.LocalDate;
import java.util.List;

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
}
