/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.services.certificates.divorcecertificates.DivorceCertificateService;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

@Component
@Profile("dev")
public class DataLoadTwoPartyCertificates {

    private static final Logger logger = LogManager.getLogger(DataLoadTwoPartyCertificates.class);

    private final MarriageCertificateService marriageCertificateService;
    private final DivorceCertificateService divorceCertificateService;
    private final PersonService personService;

    public DataLoadTwoPartyCertificates(MarriageCertificateService marriageCertificateService,
                                        DivorceCertificateService divorceCertificateService,
                                        PersonService personService) {

        this.marriageCertificateService = marriageCertificateService;
        this.divorceCertificateService = divorceCertificateService;
        this.personService = personService;
    }

    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadMarriageCertificates();
        loadDivorceCertificates();
    }


    private void loadMarriageCertificates() {
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setGroom(personService.findById(1L));
        marriageCertificate.setBride(personService.findById(2L));
        marriageCertificateService.save(marriageCertificate);

    }

    private void loadDivorceCertificates() {
        DivorceCertificate divorceCertificate = new DivorceCertificate();
        divorceCertificate.setFirstParty(personService.findById(1L));
        divorceCertificate.setSecondParty(personService.findById(2L));
        divorceCertificateService.save(divorceCertificate);
    }


}
