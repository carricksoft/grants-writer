/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;


import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.images.PlaceImage;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;

import java.util.List;

public interface PlaceImageService {
    List<PlaceImage> findAllByPlace(Place place);
    PlaceImage findById(Long id);
}
