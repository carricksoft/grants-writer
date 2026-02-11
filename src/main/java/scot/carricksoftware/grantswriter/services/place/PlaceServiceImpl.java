/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.place;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.place.PlaceRepository;


import java.util.ArrayList;
import java.util.List;


@Service
public class PlaceServiceImpl implements PlaceService{

    private static final Logger logger = LogManager.getLogger(PlaceServiceImpl.class);

    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<Place> findAll() {
        logger.debug("PersonServiceImpl::findAll");
        List<Place> result = new ArrayList<>();
        Iterable<Place> placeIterable = placeRepository.findAll(getSort());
        placeIterable.forEach(result::add);
        return result;
    }

    private Sort getSort() {
        return Sort.by(
                Sort.Order.asc("name"));
    }
}
