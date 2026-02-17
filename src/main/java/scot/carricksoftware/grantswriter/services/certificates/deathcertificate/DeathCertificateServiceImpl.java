/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.deathcertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.certificates.deathcertificate.DeathCertificateRepository;


import java.util.ArrayList;
import java.util.List;

@Component
public class DeathCertificateServiceImpl implements DeathCertificateService {

    private static final Logger logger = LogManager.getLogger(DeathCertificateServiceImpl.class);

    private final DeathCertificateRepository deathCertificateRepository;

    public DeathCertificateServiceImpl(DeathCertificateRepository deathCertificateRepository) {
        this.deathCertificateRepository = deathCertificateRepository;
    }

    @Override
    public List<DeathCertificate> findAllByDeceased(Person person) {
        logger.debug("PersonServiceImpl::findAllByDeceased");
        List<DeathCertificate> result = new ArrayList<>();
        Iterable<DeathCertificate> deathCertificatesIterable = deathCertificateRepository.findAllByDeceased(person);
        for (DeathCertificate deathCertificate : deathCertificatesIterable) {
            result.add(deathCertificate);
        }
        return result;
    }


    @Override
    public List<DeathCertificate> findAllBySpouse(Person person) {
        logger.debug("PersonServiceImpl::findAllBySpouse");
        List<DeathCertificate> result = new ArrayList<>();
        Iterable<DeathCertificate> deathCertificatesIterable = deathCertificateRepository.findAllBySpouse(person);
        for (DeathCertificate deathCertificate : deathCertificatesIterable) {
            result.add(deathCertificate);
        }
        return result;
    }

    @Override
    public List<DeathCertificate> findAllByWhereDied(Place place) {
        logger.debug("PersonServiceImpl::findAllByWhereDied");
        List<DeathCertificate> result = new ArrayList<>();
        Iterable<DeathCertificate> deathCertificatesIterable = deathCertificateRepository.findAllByWhereDied(place);
        for (DeathCertificate deathCertificate : deathCertificatesIterable) {
            result.add(deathCertificate);
        }
        return result;
    }

    @Override
    public List<DeathCertificate> findAllByWhereRegistered(Place place) {
        logger.debug("PersonServiceImpl::findAllByWhereRegistered");
        List<DeathCertificate> result = new ArrayList<>();
        Iterable<DeathCertificate> deathCertificatesIterable = deathCertificateRepository.findAllByWhereRegistered(place);
        for (DeathCertificate deathCertificate : deathCertificatesIterable) {
            result.add(deathCertificate);
        }
        return result;
    }

    @Override
    public List<DeathCertificate> findAllByInformant(Person person) {
        logger.debug("PersonServiceImpl::findAllByInformant");
        List<DeathCertificate> result = new ArrayList<>();
        Iterable<DeathCertificate> deathCertificatesIterable = deathCertificateRepository.findAllByInformant(person);
        for (DeathCertificate deathCertificate : deathCertificatesIterable) {
            result.add(deathCertificate);
        }
        return result;
    }
}
