package be.svt.test.core.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Team {
    private String name;
    private Club club;
    private Set<Member> members;

    public Team(String name, Club club, Set<Member> members) {
        this.name = name;
        this.club = club;
        this.members = members;
    }

    public Team(String name, Club club) {
        this(name, club, new HashSet<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) &&
                Objects.equals(club, team.club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, club);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", club=" + club.getName() +
                ", members=" + members.stream().map(member -> member.getFirstName() + " " + member.getLastName()) +
                '}';
    }
}
