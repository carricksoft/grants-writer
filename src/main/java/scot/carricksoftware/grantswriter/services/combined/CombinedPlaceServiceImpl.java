/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.domains.places.Place;

@Service
public class CombinedPlaceServiceImpl implements CombinedPlaceService {
    @Override
    public CombinedContentList getPlaceContent(Place place) {
        return null;
    }
}
