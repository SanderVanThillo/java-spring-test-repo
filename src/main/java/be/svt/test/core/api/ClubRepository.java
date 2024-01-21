package be.svt.test.core.api;

import be.svt.test.core.domain.Club;

import java.util.Optional;
import java.util.Set;

public interface ClubRepository {
    Set<Club> getClubs();
    Optional<Club> getClub(String name);
    Club addClub(Club club);
}
