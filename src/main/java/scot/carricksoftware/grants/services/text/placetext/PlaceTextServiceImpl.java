/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.placetext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextConverterImpl;
import scot.carricksoftware.grants.domains.text.PlaceText;
import scot.carricksoftware.grants.repositories.text.PlaceTextRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceTextServiceImpl implements PlaceTextService {

    private static final Logger logger = LogManager.getLogger(PlaceTextServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final PlaceTextRepository placeTextRepository;
    private final PlaceTextConverterImpl placeTextConverterImpl;
    private final PlaceTextCommandConverterImpl placeTextCommandConverterImpl;

    public PlaceTextServiceImpl(
            PlaceTextRepository placeTextRepository,
            PlaceTextConverterImpl placeTextConverterImpl,
            PlaceTextCommandConverterImpl placeTextCommandConverterImpl) {

        this.placeTextRepository = placeTextRepository;
        this.placeTextConverterImpl = placeTextConverterImpl;
        this.placeTextCommandConverterImpl = placeTextCommandConverterImpl;
    }

    @Override
    public PlaceText findById(Long id) {
        logger.debug("PlaceTextServiceImpl::findById");
        Optional<PlaceText> placeTextOptional = placeTextRepository.findById(id);
        return placeTextOptional.orElse(null);
    }

    public PlaceText save(PlaceText placeText) {
        logger.debug("PlaceTextServiceImpl::save");
        return placeTextRepository.save(placeText);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("PlaceTextServiceImpl::deleteBy");
        placeTextRepository.deleteById(id);
    }

    @Override
    public List<PlaceText> getPagedPlaceTexts(int pageNumber) {
        logger.debug("PlaceTextServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<PlaceText> pagedResult = placeTextRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("PlaceTextServiceImpl::count");
        return placeTextRepository.count();
    }

    @Transactional
    @Override
    public PlaceTextCommand savePlaceTextCommand(PlaceTextCommand placeTextCommand) {
        logger.debug("PlaceTextServiceImpl::savePlaceTextCommand");
        PlaceText placeText = placeTextCommandConverterImpl.convert(placeTextCommand);
        PlaceText savedPlaceText = placeTextRepository.save(placeText);
        return placeTextConverterImpl.convert(savedPlaceText);

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
