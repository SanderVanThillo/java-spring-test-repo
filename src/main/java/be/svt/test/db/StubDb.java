package be.svt.test.db;

import be.svt.test.core.api.ClubRepository;
import be.svt.test.core.api.MemberRepository;
import be.svt.test.core.api.TeamRepository;
import be.svt.test.core.domain.Address;
import be.svt.test.core.domain.Club;
import be.svt.test.core.domain.Member;
import be.svt.test.core.domain.Team;
import jakarta.annotation.PostConstruct;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StubDb implements ClubRepository, TeamRepository, MemberRepository {
    private Set<Club> clubs = new HashSet<>();
    private Set<Team> teams = new HashSet<>();
    private Set<Member> members = new HashSet<>();

    @Override
    public Set<Club> getClubs() {
        return clubs;
    }

    @Override
    public Optional<Club> getClub(String name) {
        return clubs.stream()
                .filter(club -> club.getName().equals(name))
                .findAny();
    }

    @Override
    public Club addClub(Club club) {
        clubs.add(club);
        return club;
    }

    @Override
    public Set<Team> getTeams() {
        return teams;
    }

    @Override
    public Set<Team> getTeamsOfClub(String clubName) {
        return teams.stream()
                .filter(team -> team.getClub().getName().equals(clubName))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Team> getTeam(String teamName) {
        return teams.stream()
                .filter(team -> team.getName().equals(teamName))
                .findAny();
    }

    @Override
    public Team addTeam(Team team) {
        teams.add(team);
        return team;
    }

    @Override
    public Set<Member> getMembers() {
        return members;
    }

    @Override
    public Set<Member> getMembersOfClub(String clubName) {
        return members.stream()
                .filter(member -> member.getClub().getName().equals(clubName))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Member> getMembersOfTeam(String teamName) {
        return members.stream()
                .filter(member -> member.getTeam().getName().equals(teamName))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Member> getMember(String email) {
        return members.stream()
                .filter(member -> member.getEmail().equals(email))
                .findAny();
    }

    @Override
    public Member addMember(Member member) {
        members.add(member);
        return member;
    }

    @PostConstruct
    public void setUp() {
        Club clubLennik = new Club("VC Lennik Heren", new Address("Alfred Algoetstraat", "77", 1750, "Lennik"));
        Team teamLennik = new Team("Lennik Heren 1", clubLennik);
        Member memberLennik = new Member("Jan", "Jansens", LocalDate.of(2000, Month.JUNE, 15), null, "jan.jansens@hotmail.com" ,clubLennik, teamLennik);
        clubLennik.addTeam(teamLennik);
        clubLennik.addMember(memberLennik);
        teamLennik.addMember(memberLennik);

        Club clubWolvertem = new Club("Wolvertem Sporting", new Address("Populierenlaan", "20", 1861, "Meise"));
        Team teamWolvertem1 = new Team("Wolvertem Heren 1", clubWolvertem);
        Member memberWolvertem1 = new Member("Peter", "Peters", LocalDate.of(2002, Month.SEPTEMBER, 28), null, "peter.peters@gmail.com", clubWolvertem, teamWolvertem1);
        Member memberWolvertem2 = new Member("Tom", "Thompson", LocalDate.of(1998, Month.MARCH, 4), null, "tom.thompson@gmail.com", clubWolvertem, teamWolvertem1);
        Team teamWolvertem2 = new Team("Wolvertem Dames 1", clubWolvertem);
        Member memberWolvertem3 = new Member("Hannah", "Maes", LocalDate.of(2001, Month.DECEMBER, 22), null, "hannah.maes@hotmail.com", clubWolvertem, teamWolvertem2);
        clubWolvertem.setTeams(new HashSet<>(Set.of(teamWolvertem1, teamWolvertem2)));
        clubWolvertem.setMembers(new HashSet<>(Set.of(memberWolvertem1, memberWolvertem2, memberWolvertem3)));
        teamWolvertem1.setMembers(new HashSet<>(Set.of(memberWolvertem1, memberWolvertem2)));
        teamWolvertem2.addMember(memberWolvertem3);

        clubs = new HashSet<>(Set.of(clubLennik, clubWolvertem));
        teams = new HashSet<>(Set.of(teamLennik, teamWolvertem1, teamWolvertem2));
        members = new HashSet<>(Set.of(memberLennik, memberWolvertem1, memberWolvertem2, memberWolvertem3));
    }
}
