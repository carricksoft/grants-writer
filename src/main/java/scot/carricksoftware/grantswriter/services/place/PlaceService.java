/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.place;

import scot.carricksoftware.grantswriter.domains.places.Place;

import java.util.List;

public interface PlaceService {
    List<Place> findAll();
}
