/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.divorcecertificate.DivorceCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.GatherDivorceCertificateFirstPartyTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.GatherDivorceCertificateSecondPartyTimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;


import java.util.List;


@Component
public class GatherDivorceCertificateTimeLineDataImpl implements GatherDivorceCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherDivorceCertificateTimeLineDataImpl.class);

    private final DivorceCertificateService divorceCertificateService;

    private final GatherDivorceCertificateFirstPartyTimeLineData gatherDivorceCertificateFirstPartyTimeLineData;
    private final GatherDivorceCertificateSecondPartyTimeLineData gatherDivorceCertificateSecondPartyTimeLineData;

    public GatherDivorceCertificateTimeLineDataImpl(DivorceCertificateService divorceCertificateService,
                                                    GatherDivorceCertificateFirstPartyTimeLineData gatherDivorceCertificateFirstPartyTimeLineData,
                                                    GatherDivorceCertificateSecondPartyTimeLineData gatherDivorceCertificateSecondPartyTimeLineData) {
        this.divorceCertificateService = divorceCertificateService;
        this.gatherDivorceCertificateFirstPartyTimeLineData = gatherDivorceCertificateFirstPartyTimeLineData;
        this.gatherDivorceCertificateSecondPartyTimeLineData = gatherDivorceCertificateSecondPartyTimeLineData;
    }

    @Override
    public void gather(Person person) {
        logger.debug("GatherDivorceCertificateTimeLineDataImpl::gather");
        gatherFirstParty(person);
        gatherSecondParty(person);
    }

    private void gatherFirstParty(Person person) {
        logger.debug("GatherDivorceCertificateTimeLineDataImpl::gatherParty");
        List<DivorceCertificate> divorceCertificates = divorceCertificateService.findAllByFirstParty(person);
        if (!divorceCertificates.isEmpty()) {
            gatherDivorceCertificateFirstPartyTimeLineData.gather(divorceCertificates);
        }
    }

    private void gatherSecondParty(Person person) {
        logger.debug("GatherDivorceCertificateTimeLineDataImpl::gatherSecondParty");
        List<DivorceCertificate> divorceCertificates = divorceCertificateService.findAllBySecondParty(person);
        if (!divorceCertificates.isEmpty()) {
            gatherDivorceCertificateSecondPartyTimeLineData.gather(divorceCertificates);
        }
    }

}
