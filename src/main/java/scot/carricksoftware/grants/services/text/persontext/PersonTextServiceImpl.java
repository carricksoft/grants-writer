/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.persontext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextConverterImpl;
import scot.carricksoftware.grants.domains.text.PersonText;
import scot.carricksoftware.grants.repositories.text.PersonTextRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonTextServiceImpl implements PersonTextService {

    private static final Logger logger = LogManager.getLogger(PersonTextServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final PersonTextRepository personTextRepository;
    private final PersonTextConverterImpl personTextConverterImpl;
    private final PersonTextCommandConverterImpl personTextCommandConverterImpl;

    public PersonTextServiceImpl(
            PersonTextRepository personTextRepository,
            PersonTextConverterImpl personTextConverterImpl,
            PersonTextCommandConverterImpl personTextCommandConverterImpl) {

        this.personTextRepository = personTextRepository;
        this.personTextConverterImpl = personTextConverterImpl;
        this.personTextCommandConverterImpl = personTextCommandConverterImpl;
    }

    @Override
    public PersonText findById(Long id) {
        logger.debug("PersonTextServiceImpl::findById");
        Optional<PersonText> personTextOptional = personTextRepository.findById(id);
        return personTextOptional.orElse(null);
    }

    public PersonText save(PersonText personText) {
        logger.debug("PersonTextServiceImpl::save");
        return personTextRepository.save(personText);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("PersonTextServiceImpl::deleteBy");
        personTextRepository.deleteById(id);
    }

    @Override
    public List<PersonText> getPagedPersonTexts(int pageNumber) {
        logger.debug("PersonTextServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<PersonText> pagedResult = personTextRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("PersonTextServiceImpl::count");
        return personTextRepository.count();
    }

    @Transactional
    @Override
    public PersonTextCommand savePersonTextCommand(PersonTextCommand personTextCommand) {
        logger.debug("PersonTextServiceImpl::savePersonTextCommand");
        PersonText personText = personTextCommandConverterImpl.convert(personTextCommand);
        PersonText savedPersonText = personTextRepository.save(personText);
        return personTextConverterImpl.convert(savedPersonText);

    }

    @Override
    public List<PersonText> findAll() {
        logger.debug("PersonTextServiceImpl::findAll");
        List<PersonText> result = new ArrayList<>();
        Iterable<PersonText> personTextIterable = personTextRepository.findAll();
        personTextIterable.forEach(result::add);
        return result;
    }

}
