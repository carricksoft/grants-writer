/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.marriagecertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.certificates.marriagecertificate.MarriageCertificateRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarriageCertificateServiceImpl implements MarriageCertificateService {

    private static final Logger logger = LogManager.getLogger(MarriageCertificateServiceImpl.class);

    private final MarriageCertificateRepository marriageCertificateRepository;

    public MarriageCertificateServiceImpl(MarriageCertificateRepository marriageCertificateRepository) {
        this.marriageCertificateRepository = marriageCertificateRepository;
    }

    @Override
    public List<MarriageCertificate> findAllByBride(Person person) {
        logger.debug("MarriageCertificateServiceImpl::findAllByBride");
        List<MarriageCertificate> result = new ArrayList<>();
        Iterable<MarriageCertificate> marriageCertificatesIterable = marriageCertificateRepository.findAllByBride(person);
        for (MarriageCertificate marriageCertificate : marriageCertificatesIterable) {
            result.add(marriageCertificate);
        }
        return result;
    }

    @Override
    public List<MarriageCertificate> findAllByGroom(Person person) {
        logger.debug("MarriageCertificateServiceImpl::findAllByGroom");
        List<MarriageCertificate> result = new ArrayList<>();
        Iterable<MarriageCertificate> marriageCertificatesIterable = marriageCertificateRepository.findAllByGroom(person);
        for (MarriageCertificate marriageCertificate : marriageCertificatesIterable) {
            result.add(marriageCertificate);
        }
        return result;
    }

    @Override
    public List<MarriageCertificate> findAllByFirstWitness(Person person) {
        logger.debug("MarriageCertificateServiceImpl::findAllByFirstWitness");
        List<MarriageCertificate> result = new ArrayList<>();
        Iterable<MarriageCertificate> marriageCertificatesIterable = marriageCertificateRepository.findAllByFirstWitness(person);
        for (MarriageCertificate marriageCertificate : marriageCertificatesIterable) {
            result.add(marriageCertificate);
        }
        return result;
    }

    @Override
    public List<MarriageCertificate> findAllBySecondWitness(Person person) {
        logger.debug("MarriageCertificateServiceImpl::findAllBySecondWitness");
        List<MarriageCertificate> result = new ArrayList<>();
        Iterable<MarriageCertificate> marriageCertificatesIterable = marriageCertificateRepository.findAllBySecondWitness(person);
        for (MarriageCertificate marriageCertificate : marriageCertificatesIterable) {
            result.add(marriageCertificate);
        }
        return result;
    }

}
