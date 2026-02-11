/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.census;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.places.Place;


import java.util.List;

@Service
public interface CensusService {

    List<Census> findAllByPlace(Place place);
}
