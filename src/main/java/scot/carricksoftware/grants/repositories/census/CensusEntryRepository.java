/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.census;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.util.Optional;

@Repository
public interface CensusEntryRepository extends PagingAndSortingRepository<CensusEntry, Long> {

    CensusEntry save(CensusEntry censusEntry);

    long count();

    void deleteById(Long id);

    Optional<CensusEntry> findById(Long id);

    Iterable<CensusEntry> findAll();
}
