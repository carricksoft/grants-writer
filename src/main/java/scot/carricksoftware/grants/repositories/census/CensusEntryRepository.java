/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.census;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.census.CensusEntry;

@SuppressWarnings("unused")
@Repository
public interface CensusEntryRepository extends PagingAndSortingRepository<CensusEntry, Long> {

}
