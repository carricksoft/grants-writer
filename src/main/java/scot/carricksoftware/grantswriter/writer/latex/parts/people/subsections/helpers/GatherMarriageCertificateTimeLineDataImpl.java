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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateBrideTimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateFirstWitnessTimeLineDataImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateSecondWitnessTimeLineDataImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateGroomTimeLineData;

import java.util.List;


@Component
public class GatherMarriageCertificateTimeLineDataImpl implements GatherMarriageCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherMarriageCertificateTimeLineDataImpl.class);

    private final MarriageCertificateService marriageCertificateService;
    private final GatherMarriageCertificateBrideTimeLineData gatherMarriageCertificateBrideTimeLineData;
    private final GatherMarriageCertificateGroomTimeLineData gatherMarriageCertificateGroomTimeLineData;
    private final GatherMarriageCertificateFirstWitnessTimeLineDataImpl gatherMarriageCertificateFirstWitnessTimeLineDataImpl;
    private final GatherMarriageCertificateSecondWitnessTimeLineDataImpl gatherMarriageCertificateSecondWitnessTimeLineDataImpl;

    public GatherMarriageCertificateTimeLineDataImpl(MarriageCertificateService marriageCertificateService,
                                                     GatherMarriageCertificateBrideTimeLineData gatherMarriageCertificateBrideTimeLineData,
                                                     GatherMarriageCertificateGroomTimeLineData gatherMarriageCertificateGroomTimeLineData, GatherMarriageCertificateFirstWitnessTimeLineDataImpl gatherMarriageCertificateFirstWitnessTimeLineDataImpl, GatherMarriageCertificateSecondWitnessTimeLineDataImpl gatherMarriageCertificateSecondWitnessTimeLineDataImpl) {
        this.marriageCertificateService = marriageCertificateService;
        this.gatherMarriageCertificateBrideTimeLineData = gatherMarriageCertificateBrideTimeLineData;
        this.gatherMarriageCertificateGroomTimeLineData = gatherMarriageCertificateGroomTimeLineData;
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
            gatherMarriageCertificateBrideTimeLineData.gather(marriageCertificates);
        }
    }

    private void gatherGroom(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherGroom");
        List<MarriageCertificate> marriageCertificates = marriageCertificateService.findAllByGroom(person);
        if (!marriageCertificates.isEmpty()) {
            gatherMarriageCertificateGroomTimeLineData.gather(marriageCertificates);
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
