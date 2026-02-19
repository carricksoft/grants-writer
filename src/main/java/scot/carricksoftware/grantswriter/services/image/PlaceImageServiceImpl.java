/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.images.PlaceImage;
import scot.carricksoftware.grantswriter.repositories.place.PlaceImageRepository;


@Service
public class PlaceImageServiceImpl implements PlaceImageService {

    private static final Logger logger = LogManager.getLogger(PlaceImageServiceImpl.class);

    private final PlaceImageRepository placeImageRepository;

    public PlaceImageServiceImpl(PlaceImageRepository placeImageRepository) {
        this.placeImageRepository = placeImageRepository;
    }

    @Override
    public PlaceImage findById(Long id) {
        logger.info("PlaceImageService::findById");
        return placeImageRepository.findById(id);
    }
}
