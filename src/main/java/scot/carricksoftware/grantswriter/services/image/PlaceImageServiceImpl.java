/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.images.PlaceImage;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.images.PersonImageRepository;
import scot.carricksoftware.grantswriter.repositories.place.PlaceImageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceImageServiceImpl implements PlaceImageService {

    private static final Logger logger = LogManager.getLogger(PlaceImageServiceImpl.class);

    private final PlaceImageRepository placeImageRepository;

    public PlaceImageServiceImpl(PlaceImageRepository placeImageRepository) {
        this.placeImageRepository = placeImageRepository;
    }

    @Override
    public List<PlaceImage> findAllByPlace(Place place) {
        logger.debug("PlaceServiceImpl::findAllByPlace");
        List<PlaceImage> result = new ArrayList<>();
        Iterable<PlaceImage> placeImageIterable = placeImageRepository.findAllByPlace(place);
        for (PlaceImage placeImage : placeImageIterable) {
            result.add(placeImage);
        }
        return result;
    }

    @Override
    public PlaceImage findById(Long id) {
        return placeImageRepository.findById(id);
    }
}
