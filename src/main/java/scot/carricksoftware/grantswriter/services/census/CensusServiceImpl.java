/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.census;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.census.CensusRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CensusServiceImpl implements CensusService {

    private static final Logger logger = LogManager.getLogger(CensusServiceImpl.class);

    private final CensusRepository censusRepository;

    public CensusServiceImpl(CensusRepository censusRepository) {
        this.censusRepository = censusRepository;
    }

    @Override
    public List<Census> findAllByPlace(Place place) {
        logger.debug("BirthCertificateServiceImpl::findAllByWhereRegistered");
        List<Census> result = new ArrayList<>();
        Iterable<Census> censusIterable = censusRepository.findAllByPlace(place);
        for (Census census : censusIterable) {
            result.add(census);
        }
        return result;
    }
}
