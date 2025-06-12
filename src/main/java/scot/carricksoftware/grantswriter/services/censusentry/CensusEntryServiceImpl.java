/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.censusentry;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.censusentry.CensusEntryRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class CensusEntryServiceImpl implements CensusEntryService {

    private static final Logger logger = LogManager.getLogger(CensusEntryServiceImpl.class);

    private final CensusEntryRepository censusEntryRepository;

    public CensusEntryServiceImpl(CensusEntryRepository censusEntryRepository) {
        this.censusEntryRepository = censusEntryRepository;
    }

    @Override
    public List<CensusEntry> findAllByPerson(Person person) {
        logger.debug("PersonServiceImpl::findAll");
        List<CensusEntry> result = new ArrayList<>();
        Iterable<CensusEntry> censusEntryIterable = censusEntryRepository.findAllByPerson(person);
        for (CensusEntry censusEntry : censusEntryIterable) {
            result.add(censusEntry);
        }
   //     censusEntryIterable.forEach(result::add);
        return result;
    }




}
