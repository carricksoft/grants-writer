/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.countries;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.repositories.places.CountryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private static final Logger logger = LogManager.getLogger(CountryServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final CountryRepository countryRepository;
    private final CountryConverterImpl countryConverterImpl;
    private final CountryCommandConverterImpl countryCommandConverterImpl;

    public CountryServiceImpl(
            CountryRepository countryRepository,
            CountryConverterImpl countryConverterImpl,
            CountryCommandConverterImpl countryCommandConverterImpl) {

        this.countryRepository = countryRepository;
        this.countryConverterImpl = countryConverterImpl;
        this.countryCommandConverterImpl = countryCommandConverterImpl;
    }


    @Override
    public Country findById(Long id) {
        logger.debug("CountryServiceImpl::findById");
        Optional<Country> country = countryRepository.findById(id);
        return country.orElse(null);
    }

    @Override
    public Country save(Country country) {
        logger.debug("CountryServiceImpl::save");
        return countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("CountryServiceImpl::deleteBy");
        countryRepository.deleteById(id);
    }


    @Override
    public List<Country> getPagedCountries(int pageNumber) {
        logger.debug("CountryServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<Country> pagedResult = countryRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "name");
    }

    @Override
    public long count() {
        logger.debug("CountryServiceImpl::count");
        return countryRepository.count();
    }

    @Transactional
    @Override
    public CountryCommand saveCountryCommand(CountryCommand countryCommand) {
        logger.debug("CountryServiceImpl::saveCountryCommand");
        Country country = countryCommandConverterImpl.convert(countryCommand);
        Country savedCountry = countryRepository.save(country);
        return countryConverterImpl.convert(savedCountry);

    }

    @Override
    public List<Country> findAll() {
        logger.debug("CountryServiceImpl::findAll");
        List<Country> result = new ArrayList<>();
        Iterable<Country> countryIterable = countryRepository.findAll();
        countryIterable.forEach(result::add);
        return result;
    }

}
