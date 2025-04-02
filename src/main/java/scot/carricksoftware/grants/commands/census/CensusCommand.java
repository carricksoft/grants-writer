/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;
import java.util.List;

public interface CensusCommand {
    Long getId();

    void setId(Long id);

    LocalDate getDate();

    void setDate(LocalDate date);

    List<CensusEntry> getCensusEntries();

    void setCensusEntries(List<CensusEntry> censusEntries);

    Place getPlace();

    void setPlace(Place place);
}
