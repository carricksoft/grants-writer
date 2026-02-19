/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.text.PlaceText;
import scot.carricksoftware.grantswriter.repositories.text.PlaceTextRepository;


@Service
public class PlaceTextServiceImpl implements PlaceTextService {

    private static final Logger logger = LogManager.getLogger(PlaceTextServiceImpl.class);

    private final PlaceTextRepository placeTextRepository;

    public PlaceTextServiceImpl(PlaceTextRepository placeTextRepository) {
        this.placeTextRepository = placeTextRepository;
    }

    @Override
    public PlaceText findById(Long id) {
        logger.info("PlaceTextServiceImpl::findById");
        return placeTextRepository.findById(id);
    }

}
