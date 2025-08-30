/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.divorcecertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.certificates.birthcertificate.DivorceCertificateRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DivorceCertificateServiceImpl implements DivorceCertificateService {

    private static final Logger logger = LogManager.getLogger(DivorceCertificateServiceImpl.class);

    private final DivorceCertificateRepository divorceCertificateRepository;

    public DivorceCertificateServiceImpl(DivorceCertificateRepository divorceCertificateRepository) {
        this.divorceCertificateRepository = divorceCertificateRepository;
    }

    @Override
    public List<DivorceCertificate> findAllByFirstParty(Person person) {
        logger.debug("DivorceServiceImpl::findAllByFirstParty");
        List<DivorceCertificate> result = new ArrayList<>();
        Iterable<DivorceCertificate> divorceCertificatesIterable = divorceCertificateRepository.findAllByFirstParty(person);
        for (DivorceCertificate divorceCertificate : divorceCertificatesIterable) {
            result.add(divorceCertificate);
        }
        return result;
    }

    @Override
    public List<DivorceCertificate> findAllBySecondParty(Person person) {
        logger.debug("PersonServiceImpl::findAllBySecondParty");
        List<DivorceCertificate> result = new ArrayList<>();
        Iterable<DivorceCertificate> divorceCertificateIterable = divorceCertificateRepository.findAllBySecondParty(person);
        for (DivorceCertificate divorceCertificate : divorceCertificateIterable) {
            result.add(divorceCertificate);
        }
        return result;
    }


}
