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
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.repositories.census.CensusRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CensusServiceImpl implements CensusService {
    private static final Logger logger = LogManager.getLogger(CensusServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final CensusRepository censusRepository;
    private final CensusConverterImpl censusConverterImpl;
    private final CensusCommandConverterImpl censusCommandConverterImpl;

    public CensusServiceImpl(
            CensusRepository censusRepository,
            CensusConverterImpl censusConverterImpl,
            CensusCommandConverterImpl censusCommandConverterImpl) {

        this.censusRepository = censusRepository;
        this.censusConverterImpl = censusConverterImpl;
        this.censusCommandConverterImpl = censusCommandConverterImpl;
    }


    @Override
    public Census findById(Long id) {
        logger.debug("CensusServiceImpl::findById");
        Optional<Census> census = censusRepository.findById(id);
        return census.orElse(null);
    }

    @Override
    public Census save(Census census) {
        logger.debug("CensusServiceImpl::save");
        return censusRepository.save(census);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("CensusServiceImpl::deleteBy");
        censusRepository.deleteById(id);
    }


    @Override
    public List<Census> getPagedCensuses(int pageNumber) {
        logger.debug("CensusServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<Census> pagedResult = censusRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("CensusServiceImpl::count");
        return censusRepository.count();
    }

    @Transactional
    @Override
    public CensusCommand saveCensusCommand(CensusCommand censusCommand) {
        logger.debug("CensusServiceImpl::saveCensusCommand");
        Census census = censusCommandConverterImpl.convert(censusCommand);
        Census savedCensus = censusRepository.save(census);
        return censusConverterImpl.convert(savedCensus);

    }

    @Override
    public List<Census> findAll() {
        logger.debug("CensusServiceImpl::findAll");
        List<Census> result = new ArrayList<>();
        Iterable<Census> censusIterable = censusRepository.findAll();
        censusIterable.forEach(result::add);
        return result;
    }

}
