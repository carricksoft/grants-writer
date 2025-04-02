/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.places;

import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.List;

public interface PlaceService {

    @SuppressWarnings("unused")
    Place findById(Long id);

    @SuppressWarnings("unused")
    Place save(Place place);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Place> getPagedPlaces(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    PlaceCommand savePlaceCommand(PlaceCommand placeCommand);

    @SuppressWarnings("unused")
    List<Place> findAll();
}
