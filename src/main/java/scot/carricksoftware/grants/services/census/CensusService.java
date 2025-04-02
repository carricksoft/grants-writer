/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.census;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;

import java.util.List;

@Service
public interface CensusService {

    @SuppressWarnings("unused")
    Census findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    Census save(Census census);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Census> getPagedCensuses(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    CensusCommand saveCensusCommand(CensusCommand censusCommand);

    @SuppressWarnings("unused")
    List<Census> findAll();
}
