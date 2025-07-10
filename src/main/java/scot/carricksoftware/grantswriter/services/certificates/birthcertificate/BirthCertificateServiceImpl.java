/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.birthcertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.certificates.birthcertificate.BirthCertificateRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class BirthCertificateServiceImpl implements BirthCertificateService {

    private static final Logger logger = LogManager.getLogger(BirthCertificateServiceImpl.class);

    private final BirthCertificateRepository birthCertificateRepository;

    public BirthCertificateServiceImpl(BirthCertificateRepository birthCertificateRepository) {
        this.birthCertificateRepository = birthCertificateRepository;
    }

    @Override
    public List<BirthCertificate> findAllByNewBorn(Person person) {
        logger.debug("PersonServiceImpl::findAllByPerson");
        List<BirthCertificate> result = new ArrayList<>();
        Iterable<BirthCertificate> birthCertificatesIterable = birthCertificateRepository.findAllByNewBorn(person);
        for (BirthCertificate birthCertificate : birthCertificatesIterable) {
            result.add(birthCertificate);
        }
        return result;
    }
}
