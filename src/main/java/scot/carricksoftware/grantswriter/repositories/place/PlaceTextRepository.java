/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.place;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.domains.text.PlaceText;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

@Repository
public interface PlaceTextRepository extends ReadOnlyRepository<PlaceText, Long> {

    Iterable<PlaceText> findAllByPlace(Place place);
}
