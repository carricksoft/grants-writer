/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.censusentry;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

import java.util.List;

@Repository
public interface CensusEntryRepository extends ReadOnlyRepository<CensusEntry, Long> {
    List<CensusEntry> findAllByPerson(Person person);
}
