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

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceTextServiceImpl implements PlaceTextService {

    private static final Logger logger = LogManager.getLogger(PlaceTextServiceImpl.class);

    private final PlaceTextRepository placeTextRepository;

    public PlaceTextServiceImpl(PlaceTextRepository placeTextRepository) {
        this.placeTextRepository = placeTextRepository;
    }

    @Override
    public PlaceText findById(Long id) {
        return placeTextRepository.findById(id);
    }

    @Override
    public List<PlaceText> findAll() {
        logger.debug("PlaceTextServiceImpl::findAll");
        List<PlaceText> result = new ArrayList<>();
        Iterable<PlaceText> placeTextIterable = placeTextRepository.findAll();
        placeTextIterable.forEach(result::add);
        return result;
    }
}
