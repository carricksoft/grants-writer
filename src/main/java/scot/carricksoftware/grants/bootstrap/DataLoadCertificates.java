/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

@Component
public class DataLoadCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadCertificates.class);

    private final BirthCertificateService birthCertificateService;
    private final DeathCertificateService deathCertificateService;
    private final PersonService personService;

    public DataLoadCertificates(BirthCertificateService birthCertificateService,
                                DeathCertificateService deathCertificateService,
                                PersonService personService) {
        this.birthCertificateService = birthCertificateService;
        this.deathCertificateService = deathCertificateService;
        this.personService = personService;
    }


    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadBirthCertificates();
        loadDeathCertificates();
    }


    private void loadBirthCertificates() {
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificate.setNewBorn(personService.findById(1L));
        birthCertificateService.save(birthCertificate);

    }

    private void loadDeathCertificates() {
        DeathCertificate deathCertificate = new DeathCertificate();
        deathCertificate.setDeceased(personService.findById(1L));
        deathCertificateService.save(deathCertificate);
    }


}
