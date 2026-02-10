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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.GatherPeopleDivorceCertificateFirstPartyTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.GatherPeopleDivorceCertificateSecondPartyTimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;


import java.util.List;


@Component
public class GatherPeopleDivorceCertificateTimeLineDataImpl implements GatherPeopleDivorceCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherPeopleDivorceCertificateTimeLineDataImpl.class);

    private final DivorceCertificateService divorceCertificateService;

    private final GatherPeopleDivorceCertificateFirstPartyTimeLineData gatherPeopleDivorceCertificateFirstPartyTimeLineData;
    private final GatherPeopleDivorceCertificateSecondPartyTimeLineData gatherPeopleDivorceCertificateSecondPartyTimeLineData;

    public GatherPeopleDivorceCertificateTimeLineDataImpl(DivorceCertificateService divorceCertificateService,
                                                          GatherPeopleDivorceCertificateFirstPartyTimeLineData gatherPeopleDivorceCertificateFirstPartyTimeLineData,
                                                          GatherPeopleDivorceCertificateSecondPartyTimeLineData gatherPeopleDivorceCertificateSecondPartyTimeLineData) {
        this.divorceCertificateService = divorceCertificateService;
        this.gatherPeopleDivorceCertificateFirstPartyTimeLineData = gatherPeopleDivorceCertificateFirstPartyTimeLineData;
        this.gatherPeopleDivorceCertificateSecondPartyTimeLineData = gatherPeopleDivorceCertificateSecondPartyTimeLineData;
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
            gatherPeopleDivorceCertificateFirstPartyTimeLineData.gather(divorceCertificates);
        }
    }

    private void gatherSecondParty(Person person) {
        logger.debug("GatherDivorceCertificateTimeLineDataImpl::gatherSecondParty");
        List<DivorceCertificate> divorceCertificates = divorceCertificateService.findAllBySecondParty(person);
        if (!divorceCertificates.isEmpty()) {
            gatherPeopleDivorceCertificateSecondPartyTimeLineData.gather(divorceCertificates);
        }
    }

}
