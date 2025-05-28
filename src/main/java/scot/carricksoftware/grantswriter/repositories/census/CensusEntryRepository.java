/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.census;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

@SuppressWarnings("unused")
@Repository
public interface CensusEntryRepository extends ReadOnlyRepository<CensusEntry, Long> {

}
