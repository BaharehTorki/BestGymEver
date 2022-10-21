package se.nackademin.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.nackademin.exceptions.SeveralNameExistException;
import se.nackademin.model.Member;
import se.nackademin.model.MembershipType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberListsServiceTest {

    private static List<Member> memberList = new ArrayList<>();
    private final static LocalDate now = LocalDate.now();
    @BeforeAll
    static void beforeAll() {
        memberList = createTestData();
    }

    private static List<Member> createTestData() {
        //A year has 52 weeks
        memberList.add(new Member("Bahareh Torki", "9104207106", now.minusWeeks(44)));
        memberList.add(new Member("Bahareh Torki", "8108296102", now.minusWeeks(46)));
        memberList.add(new Member("Chamade Coriola", "8512021234", now.minusWeeks(48)));
        memberList.add(new Member("Liu Lingren", "9110261234", now.minusWeeks(52)));
        memberList.add(new Member("Jicky Juul", "9902149834", now.minusWeeks(58)));
        memberList.add(new Member("Kadine Karlsson", "4604151234", now.minusWeeks(60)));
        memberList.add(new Member("Ali Sam", "4604151234", now.minusMonths(62)));
        memberList.add(new Member("Jicky Juuli", "9902149834", now.minusWeeks(69)));

        return memberList;
    }

    @Test
    void should_return_MembershipType_ACTIVE_if_registration_is_less_then_year() throws SeveralNameExistException {
        MembershipType actual_2 = MemberListsService.showMembershipStatus(memberList, "8108296102");
        MembershipType actual_3 = MemberListsService.showMembershipStatus(memberList, "Chamade Coriola");
        MembershipType actual_4 = MemberListsService.showMembershipStatus(memberList, "9110261234");

        assertEquals(MembershipType.ACTIVE, actual_2);
        assertEquals(MembershipType.ACTIVE, actual_3);
        assertEquals(MembershipType.ACTIVE, actual_4);
    }

    @Test
    void should_return_MembershipType_INACTIVE_if_registration_is_more_then_year() throws SeveralNameExistException {
        MembershipType actual_1 = MemberListsService.showMembershipStatus(memberList, "9902149834");
        MembershipType actual_2 = MemberListsService.showMembershipStatus(memberList, "4604151234");
        MembershipType actual_3 = MemberListsService.showMembershipStatus(memberList, "Kadine Karlsson");
        MembershipType actual_4 = MemberListsService.showMembershipStatus(memberList, "Jicky Juul");

        assertEquals(MembershipType.INACTIVE, actual_1);
        assertEquals(MembershipType.INACTIVE, actual_2);
        assertEquals(MembershipType.INACTIVE, actual_3);
        assertEquals(MembershipType.INACTIVE, actual_4);
    }

    @Test
    void should_throw_exception_if_there_are_more_then_one_name()  {
        String expectedMessage = "There are more then one name exist, please search with Personal number.";
        String acctualMessage = "";

        try {
            MemberListsService.showMembershipStatus(memberList, "Bahareh Torki");
        } catch (SeveralNameExistException e) {
            acctualMessage = e.getMessage();
        }

        assertThrows(SeveralNameExistException.class, () -> MemberListsService.showMembershipStatus(memberList, "Bahareh Torki"));
        assertEquals(expectedMessage, acctualMessage);
    }

    @Test
    void should_return_MembershipType_INVALID_if_name_or_personal_number_is_not_exist() throws SeveralNameExistException {
        MembershipType actual_1 = MemberListsService.showMembershipStatus(memberList, "8501175465");
        MembershipType actual_2 = MemberListsService.showMembershipStatus(memberList, "Abas gholi");

        assertEquals(MembershipType.INVALID, actual_1);
        assertEquals(MembershipType.INVALID, actual_2);
    }

    @Test
    void should_return_correct_member() throws SeveralNameExistException {
        Member actual = MemberListsService.getMember(memberList, "9104207106");

        assertNotNull(actual);
        assertEquals("Bahareh Torki", actual.getName());
        assertEquals(now.minusWeeks(44), actual.getRegistrationDate());

    }
}