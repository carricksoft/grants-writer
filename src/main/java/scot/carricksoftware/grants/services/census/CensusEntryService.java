/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.census;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.util.List;

@Service
public interface CensusEntryService {

    @SuppressWarnings("unused")
    CensusEntry findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    CensusEntry save(CensusEntry censusEntry);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<CensusEntry> getPagedCensusEntries(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    CensusEntryCommand saveCensusEntryCommand(CensusEntryCommand censusEntryCommand);

    @SuppressWarnings("unused")
    List<CensusEntry> findAll();
}
