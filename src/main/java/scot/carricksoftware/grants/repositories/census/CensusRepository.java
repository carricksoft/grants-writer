/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.census;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.census.Census;

import java.util.Optional;

@Repository
public interface CensusRepository extends PagingAndSortingRepository<Census, Long> {

    Census save(Census census);

    long count();

    void deleteById(Long id);

    Optional<Census> findById(Long id);

    Iterable<Census> findAll();
}
