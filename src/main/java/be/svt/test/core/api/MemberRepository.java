package be.svt.test.core.api;

import be.svt.test.core.domain.Member;

import java.util.Optional;
import java.util.Set;

public interface MemberRepository {
    Set<Member> getMembers();
    Set<Member> getMembersOfClub(String clubName);
    Set<Member> getMembersOfTeam(String teamName);
    Optional<Member> getMember(String email);
    Member addMember(Member member);
}
