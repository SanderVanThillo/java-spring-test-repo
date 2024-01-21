package be.svt.test.core.api;

import be.svt.test.core.domain.Team;

import java.util.Optional;
import java.util.Set;

public interface TeamRepository {
    Set<Team> getTeams();
    Set<Team> getTeamsOfClub(String clubName);
    Optional<Team> getTeam(String name);
    Team addTeam(Team team);
}
