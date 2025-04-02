/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 17:17. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.places.regions;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.List;

@Component
public interface RegionCommand {


    Long getId();

    void setId(Long id);

    @SuppressWarnings("unused")
    String getName();

    @SuppressWarnings("unused")
    void setName(String name);

    Country getCountry();

    void setCountry(Country country);

    List<Place> getPlaces();

    void setPlaces(List<Place> places);
}
