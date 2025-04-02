/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.personimage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.repositories.images.PersonImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonImageServiceImpl implements PersonImageService {
    private static final Logger logger = LogManager.getLogger(PersonImageServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final PersonImageRepository personImageRepository;
    private final PersonImageConverterImpl personImageConverterImpl;
    private final PersonImageCommandConverterImpl personImageCommandConverterImpl;

    public PersonImageServiceImpl(
            PersonImageRepository personImageRepository,
            PersonImageConverterImpl personImageConverterImpl,
            PersonImageCommandConverterImpl personImageCommandConverterImpl) {

        this.personImageRepository = personImageRepository;
        this.personImageConverterImpl = personImageConverterImpl;
        this.personImageCommandConverterImpl = personImageCommandConverterImpl;
    }


    @Override
    public PersonImage findById(Long id) {
        logger.debug("PersonImageServiceImpl::findById");
        Optional<PersonImage> personImageOptional = personImageRepository.findById(id);
        return personImageOptional.orElse(null);
    }


    public PersonImage save(PersonImage personImage) {
        logger.debug("PersonImageServiceImpl::save");
        return personImageRepository.save(personImage);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("PersonImageServiceImpl::deleteBy");
        personImageRepository.deleteById(id);
    }


    @Override
    public List<PersonImage> getPagedPersonImages(int pageNumber) {
        logger.debug("PersonImageServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<PersonImage> pagedResult = personImageRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("PersonImageServiceImpl::count");
        return personImageRepository.count();
    }

    @Transactional
    @Override
    public PersonImageCommand savePersonImageCommand(PersonImageCommand personImageCommand) {
        logger.debug("PersonImageServiceImpl::savePersonImageCommand");
        PersonImage personImage = personImageCommandConverterImpl.convert(personImageCommand);
        PersonImage savedPersonImage = personImageRepository.save(personImage);
        return personImageConverterImpl.convert(savedPersonImage);

    }

    @Override
    public List<PersonImage> findAll() {
        logger.debug("PersonImageServiceImpl::findAll");
        List<PersonImage> result = new ArrayList<>();
        Iterable<PersonImage> personImageIterable = personImageRepository.findAll();
        personImageIterable.forEach(result::add);
        return result;
    }

}
