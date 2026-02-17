/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.combined.CombinedContentListImpl;
import scot.carricksoftware.grantswriter.domains.images.PlaceImage;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.domains.text.PlaceText;
import scot.carricksoftware.grantswriter.repositories.place.PlaceImageRepository;
import scot.carricksoftware.grantswriter.repositories.place.PlaceTextRepository;

@Service
public class CombinedPlaceServiceImpl implements CombinedPlaceService {

    private final PlaceTextRepository placeTextRepository;
    private final PlaceImageRepository placeImageRepository;

    public CombinedPlaceServiceImpl(PlaceTextRepository placeTextRepository,
                                    PlaceImageRepository placeImageRepository) {
        this.placeTextRepository = placeTextRepository;
        this.placeImageRepository = placeImageRepository;
    }


    @Override
    public CombinedContentList getPlaceContent(Place place) {
        CombinedContentList result = new CombinedContentListImpl();
        addPlaceText(place, result);
        addPlaceImage(place, result);
        return result;
    }

    private void addPlaceText(Place place, CombinedContentList result) {
        Iterable<PlaceText> placeIterable = placeTextRepository.findAllByPlace(place);
        for (PlaceText placeText : placeIterable) {
            result.addBaseText(placeText);
        }
    }

    private void addPlaceImage(Place place, CombinedContentList result) {
        Iterable<PlaceImage> placeImageIterable = placeImageRepository.findAllByPlace(place);
        for (PlaceImage placeImage : placeImageIterable) {
            result.addBaseImage(placeImage);
        }
    }
}
