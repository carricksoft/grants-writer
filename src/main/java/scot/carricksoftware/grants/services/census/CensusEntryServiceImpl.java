/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.census;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.census.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CensusEntryServiceImpl implements CensusEntryService {
    private static final Logger logger = LogManager.getLogger(CensusEntryServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final CensusEntryRepository censusEntryRepository;
    private final CensusEntryConverterImpl censusEntryConverterImpl;
    private final CensusEntryCommandConverterImpl censusEntryCommandConverterImpl;

    public CensusEntryServiceImpl(CensusEntryRepository censusEntryRepository, CensusEntryConverterImpl censusEntryConverterImpl, CensusEntryCommandConverterImpl censusEntryCommandConverterImpl) {
        this.censusEntryRepository = censusEntryRepository;
        this.censusEntryConverterImpl = censusEntryConverterImpl;
        this.censusEntryCommandConverterImpl = censusEntryCommandConverterImpl;
    }

    @Override
    public CensusEntry findById(Long id) {
        logger.debug("censusEntryServiceImpl::findById");
        Optional<CensusEntry> censusEntry = censusEntryRepository.findById(id);
        return censusEntry.orElse(null);
    }

    @Override
    public CensusEntry save(CensusEntry censusEntry) {
        logger.debug("censusEntryServiceImpl::save");
        return censusEntryRepository.save(censusEntry);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("censusEntryServiceImpl::deleteBy");
        censusEntryRepository.deleteById(id);
    }


    @Override
    public List<CensusEntry> getPagedCensusEntries(int pageNumber) {
        logger.debug("censusEntryServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<CensusEntry> pagedResult = censusEntryRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("censusEntryServiceImpl::count");
        return censusEntryRepository.count();
    }

    @Transactional
    @Override
    public CensusEntryCommand saveCensusEntryCommand(CensusEntryCommand censusEntryCommand) {
        logger.debug("censusEntryServiceImpl::saveCensusEntryCommand");
        CensusEntry censusEntry = censusEntryCommandConverterImpl.convert(censusEntryCommand);
        CensusEntry savedcensusEntry = censusEntryRepository.save(censusEntry);
        return censusEntryConverterImpl.convert(savedcensusEntry);
    }

    @Override
    public List<CensusEntry> findAll() {
        logger.debug("censusEntryServiceImpl::findAll");
        List<CensusEntry> result = new ArrayList<>();
        Iterable<CensusEntry> censusEntryIterable = censusEntryRepository.findAll();
        censusEntryIterable.forEach(result::add);
        return result;
    }

}
