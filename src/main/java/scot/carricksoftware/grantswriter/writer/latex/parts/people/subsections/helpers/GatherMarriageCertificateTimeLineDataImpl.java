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

import java.util.List;


@Component
public class GatherMarriageCertificateTimeLineDataImpl implements GatherMarriageCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherMarriageCertificateTimeLineDataImpl.class);

    private final MarriageCertificateService marriageCertificateService;
    private final GatherMarriageCertificateBrideTimeLineData gatherMarriageCertificateBrideTimeLineData;

    public GatherMarriageCertificateTimeLineDataImpl(MarriageCertificateService marriageCertificateService, GatherMarriageCertificateBrideTimeLineData gatherMarriageCertificateBrideTimeLineData) {
        this.marriageCertificateService = marriageCertificateService;
        this.gatherMarriageCertificateBrideTimeLineData = gatherMarriageCertificateBrideTimeLineData;
    }

    @Override
    public void gather(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gather");
        gatherBride(person);
    }

    private void gatherBride(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherDeceased");
        List<MarriageCertificate> marriageCertificates = marriageCertificateService.findAllByBride(person);
        if (!marriageCertificates.isEmpty()) {
            gatherMarriageCertificateBrideTimeLineData.gather(marriageCertificates);
        }
    }

}
