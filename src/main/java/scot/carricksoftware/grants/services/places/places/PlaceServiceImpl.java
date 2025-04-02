/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.places;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {
    private static final Logger logger = LogManager.getLogger(PlaceServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final PlaceRepository placeRepository;
    private final PlaceConverterImpl placeConverterImpl;
    private final PlaceCommandConverterImpl placeCommandConverterImpl;

    public PlaceServiceImpl(
            PlaceRepository placeRepository,
            PlaceConverterImpl placeConverterImpl,
            PlaceCommandConverterImpl placeCommandConverterImpl) {

        this.placeRepository = placeRepository;
        this.placeConverterImpl = placeConverterImpl;
        this.placeCommandConverterImpl = placeCommandConverterImpl;
    }


    @Override
    public Place findById(Long id) {
        logger.debug("PlaceServiceImpl::findById");
        Optional<Place> place = placeRepository.findById(id);
        return place.orElse(null);
    }

    @Override
    public Place save(Place place) {
        logger.debug("PlaceServiceImpl::save");
        return placeRepository.save(place);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("PlaceServiceImpl::deleteBy");
        placeRepository.deleteById(id);
    }


    @Override
    public List<Place> getPagedPlaces(int pageNumber) {
        logger.debug("PlaceServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<Place> pagedResult = placeRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "name");
    }

    @Override
    public long count() {
        logger.debug("PlaceServiceImpl::count");
        return placeRepository.count();
    }

    @Transactional
    @Override
    public PlaceCommand savePlaceCommand(PlaceCommand placeCommand) {
        logger.debug("PlaceServiceImpl::savePlaceCommand");
        Place place = placeCommandConverterImpl.convert(placeCommand);
        Place savedPlace = placeRepository.save(place);
        return placeConverterImpl.convert(savedPlace);

    }

    @Override
    public List<Place> findAll() {
        logger.debug("PlaceServiceImpl::findAll");
        List<Place> result = new ArrayList<>();
        Iterable<Place> placeIterable = placeRepository.findAll();
        placeIterable.forEach(result::add);
        return result;
    }

}
