/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.placeimage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.repositories.images.PlaceImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceImageServiceImpl implements PlaceImageService {
    private static final Logger logger = LogManager.getLogger(PlaceImageServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final PlaceImageRepository placeImageRepository;
    private final PlaceImageConverterImpl placeImageConverterImpl;
    private final PlaceImageCommandConverterImpl placeImageCommandConverterImpl;

    public PlaceImageServiceImpl(
            PlaceImageRepository placeImageRepository,
            PlaceImageConverterImpl placeImageConverterImpl,
            PlaceImageCommandConverterImpl placeImageCommandConverterImpl) {

        this.placeImageRepository = placeImageRepository;
        this.placeImageConverterImpl = placeImageConverterImpl;
        this.placeImageCommandConverterImpl = placeImageCommandConverterImpl;
    }


    @Override
    public PlaceImage findById(Long id) {
        logger.debug("PlaceImageServiceImpl::findById");
        Optional<PlaceImage> placeImageOptional = placeImageRepository.findById(id);
        return placeImageOptional.orElse(null);
    }


    public PlaceImage save(PlaceImage placeImage) {
        logger.debug("PlaceImageServiceImpl::save");
        return placeImageRepository.save(placeImage);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("PlaceImageServiceImpl::deleteBy");
        placeImageRepository.deleteById(id);
    }


    @Override
    public List<PlaceImage> getPagedPlaceImages(int pageNumber) {
        logger.debug("PlaceImageServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<PlaceImage> pagedResult = placeImageRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("PlaceImageServiceImpl::count");
        return placeImageRepository.count();
    }

    @Transactional
    @Override
    public PlaceImageCommand savePlaceImageCommand(PlaceImageCommand placeImageCommand) {
        logger.debug("PlaceImageServiceImpl::savePlaceImageCommand");
        PlaceImage placeImage = placeImageCommandConverterImpl.convert(placeImageCommand);
        PlaceImage savedPlaceImage = placeImageRepository.save(placeImage);
        return placeImageConverterImpl.convert(savedPlaceImage);

    }

    @Override
    public List<PlaceImage> findAll() {
        logger.debug("PlaceImageServiceImpl::findAll");
        List<PlaceImage> result = new ArrayList<>();
        Iterable<PlaceImage> placeImageIterable = placeImageRepository.findAll();
        placeImageIterable.forEach(result::add);
        return result;
    }

}
