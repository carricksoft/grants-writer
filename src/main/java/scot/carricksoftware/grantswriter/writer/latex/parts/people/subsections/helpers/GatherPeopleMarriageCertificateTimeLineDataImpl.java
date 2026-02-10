/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.marriagecertificate.MarriageCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherPeopleMarriageCertificateBrideTimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherPeopleMarriageCertificateFirstWitnessTimeLineDataImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherPeopleMarriageCertificateSecondWitnessTimeLineDataImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherPeopleMarriageCertificateGroomTimeLineData;

import java.util.List;


@Component
public class GatherPeopleMarriageCertificateTimeLineDataImpl implements GatherPeopleMarriageCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherPeopleMarriageCertificateTimeLineDataImpl.class);

    private final MarriageCertificateService marriageCertificateService;
    private final GatherPeopleMarriageCertificateBrideTimeLineData gatherPeopleMarriageCertificateBrideTimeLineData;
    private final GatherPeopleMarriageCertificateGroomTimeLineData gatherPeopleMarriageCertificateGroomTimeLineData;
    private final GatherPeopleMarriageCertificateFirstWitnessTimeLineDataImpl gatherMarriageCertificateFirstWitnessTimeLineDataImpl;
    private final GatherPeopleMarriageCertificateSecondWitnessTimeLineDataImpl gatherMarriageCertificateSecondWitnessTimeLineDataImpl;

    public GatherPeopleMarriageCertificateTimeLineDataImpl(MarriageCertificateService marriageCertificateService,
                                                           GatherPeopleMarriageCertificateBrideTimeLineData gatherPeopleMarriageCertificateBrideTimeLineData,
                                                           GatherPeopleMarriageCertificateGroomTimeLineData gatherPeopleMarriageCertificateGroomTimeLineData, GatherPeopleMarriageCertificateFirstWitnessTimeLineDataImpl gatherMarriageCertificateFirstWitnessTimeLineDataImpl, GatherPeopleMarriageCertificateSecondWitnessTimeLineDataImpl gatherMarriageCertificateSecondWitnessTimeLineDataImpl) {
        this.marriageCertificateService = marriageCertificateService;
        this.gatherPeopleMarriageCertificateBrideTimeLineData = gatherPeopleMarriageCertificateBrideTimeLineData;
        this.gatherPeopleMarriageCertificateGroomTimeLineData = gatherPeopleMarriageCertificateGroomTimeLineData;
        this.gatherMarriageCertificateFirstWitnessTimeLineDataImpl = gatherMarriageCertificateFirstWitnessTimeLineDataImpl;
        this.gatherMarriageCertificateSecondWitnessTimeLineDataImpl = gatherMarriageCertificateSecondWitnessTimeLineDataImpl;
    }

    @Override
    public void gather(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gather");
        gatherBride(person);
        gatherGroom(person);
        gatherFirstWitness(person);
        gatherSecondWitness(person);
    }

    private void gatherBride(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherBride");
        List<MarriageCertificate> marriageCertificates = marriageCertificateService.findAllByBride(person);
        if (!marriageCertificates.isEmpty()) {
            gatherPeopleMarriageCertificateBrideTimeLineData.gather(marriageCertificates);
        }
    }

    private void gatherGroom(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherGroom");
        List<MarriageCertificate> marriageCertificates = marriageCertificateService.findAllByGroom(person);
        if (!marriageCertificates.isEmpty()) {
            gatherPeopleMarriageCertificateGroomTimeLineData.gather(marriageCertificates);
        }
    }

    private void gatherFirstWitness(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherFirstWitness");
        List<MarriageCertificate> marriageCertificates = marriageCertificateService.findAllByFirstWitness(person);
        if (!marriageCertificates.isEmpty()) {
            gatherMarriageCertificateFirstWitnessTimeLineDataImpl.gather(marriageCertificates);
        }
    }

    private void gatherSecondWitness(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherSecondWitness");
        List<MarriageCertificate> marriageCertificates = marriageCertificateService.findAllBySecondWitness(person);
        if (!marriageCertificates.isEmpty()) {
            gatherMarriageCertificateSecondWitnessTimeLineDataImpl.gather(marriageCertificates);
        }
    }

}
