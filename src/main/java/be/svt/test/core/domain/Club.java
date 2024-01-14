package be.svt.test.core.domain;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Club {
    private String name;
    private Address address;
    private Set<Team> teams;
    private Set<Member> members;

    public Club(String name, Address address, Set<Team> teams, Set<Member> members) {
        this.name = name;
        this.address = address;
        this.teams = teams;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(name, club.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Club{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", teams=" + teams.stream().map(Team::getName).collect(Collectors.toSet()) +
                ", members=" + members.stream().map(member -> member.getFirstName() + " " + member.getLastName()).collect(Collectors.toSet()) +
                '}';
    }
}
