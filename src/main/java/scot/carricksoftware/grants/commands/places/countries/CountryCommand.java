/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 17:17. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.places.countries;

import scot.carricksoftware.grants.domains.places.Region;

import java.util.List;

public interface CountryCommand {

    Long getId();

    void setId(Long id);

    @SuppressWarnings("unused")
    String getName();

    @SuppressWarnings("unused")
    void setName(String name);

    List<Region> getRegions();

    void setRegions(List<Region> regions);
}


