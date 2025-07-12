/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.repositories.censusentry.CensusEntryRepository;
import scot.carricksoftware.grantswriter.repositories.certificates.birthcertificate.BirthCertificateRepository;
import scot.carricksoftware.grantswriter.repositories.people.PersonRepository;

import java.util.LinkedHashMap;

@Service
public class StatusServiceImpl implements StatusService {

    private static final Logger logger = LogManager.getLogger(StatusServiceImpl.class);
    private final PersonRepository personRepository;
    private final BirthCertificateRepository birthCertificateRepository;
    private final CensusEntryRepository censusEntryRepository;


    private final LinkedHashMap<String, String> status = new LinkedHashMap<>();

    public StatusServiceImpl(PersonRepository personRepository,
                             BirthCertificateRepository birthCertificateRepository,
                             CensusEntryRepository censusEntryRepository) {
        this.personRepository = personRepository;
        this.birthCertificateRepository = birthCertificateRepository;
        this.censusEntryRepository = censusEntryRepository;
    }


    @Override
    public LinkedHashMap<String, String> getStatus() {
        logger.info("StatusService::getStatus");

        status.put("People", personRepository.count().toString());
        status.put("Birth Certificates", birthCertificateRepository.count().toString());
        status.put("Marriage Certificates", "0");
        status.put("Divorce Certificates", "0");
        status.put("Death Certificates", "0");
        status.put("", "");
        status.put("Censuses", "0");
        status.put("Census Entries", censusEntryRepository.count().toString());
        return status;
    }

}
