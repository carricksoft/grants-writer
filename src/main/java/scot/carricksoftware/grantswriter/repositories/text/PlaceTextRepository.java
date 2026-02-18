/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.repositories.text;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.domains.text.PlaceText;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;

@Repository
public interface PlaceTextRepository extends ReadOnlyRepository<PlaceText, Long> {


    PlaceText findById(Long id);

    Iterable<PlaceText> findAllByPlace(Place place);

    Iterable<PlaceText> findAll();
}
