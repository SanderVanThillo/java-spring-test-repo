package be.svt.test.core.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Member {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Address address;
    private String email;
    private Club club;
    private Team team;

    public Member(String firstName, String lastName, LocalDate birthDate, Address address, String email, Club club, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.email = email;
        this.club = club;
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeams(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(firstName, member.firstName) &&
                Objects.equals(lastName, member.lastName) &&
                Objects.equals(birthDate, member.birthDate) &&
                Objects.equals(email, member.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, email);
    }

    @Override
    public String toString() {
        return "Member{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", club=" + club.getName() +
                ", teams=" + team.getName() +
                '}';
    }
}
