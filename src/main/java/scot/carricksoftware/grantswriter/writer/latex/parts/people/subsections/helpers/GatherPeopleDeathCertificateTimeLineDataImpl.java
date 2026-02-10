/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.deathcertificate.DeathCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.deathcertificate.GatherPeopleDeathCertificateDeceasedTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.deathcertificate.GatherPeopleDeathCertificateInformantTimeLineData;

import java.util.List;


@Component
public class GatherPeopleDeathCertificateTimeLineDataImpl implements GatherPeopleDeathCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherPeopleDeathCertificateTimeLineDataImpl.class);

    private final DeathCertificateService deathCertificateService;
    private final GatherPeopleDeathCertificateDeceasedTimeLineData gatherPeopleDeathCertificateDeceasedTimeLineData;
    private final GatherPeopleDeathCertificateInformantTimeLineData gatherPeopleDeathCertificateInformantTimeLineData;

    public GatherPeopleDeathCertificateTimeLineDataImpl(DeathCertificateService deathCertificateService, GatherPeopleDeathCertificateDeceasedTimeLineData gatherPeopleDeathCertificateDeceasedTimeLineData, GatherPeopleDeathCertificateInformantTimeLineData gatherPeopleDeathCertificateInformantTimeLineData) {
        this.deathCertificateService = deathCertificateService;
        this.gatherPeopleDeathCertificateDeceasedTimeLineData = gatherPeopleDeathCertificateDeceasedTimeLineData;
        this.gatherPeopleDeathCertificateInformantTimeLineData = gatherPeopleDeathCertificateInformantTimeLineData;
    }

    @Override
    public void gather(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gather");
        gatherDeceased(person);
        gatherInformant(person);
    }

    private void gatherDeceased(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherDeceased");
        List<DeathCertificate> deathCertificates = deathCertificateService.findAllByDeceased(person);
        if (!deathCertificates.isEmpty()) {
            gatherPeopleDeathCertificateDeceasedTimeLineData.gather(deathCertificates);
        }
    }

    private void gatherInformant(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherInformant");
        List<DeathCertificate> deathCertificates = deathCertificateService.findAllByInformant(person);
        if (!deathCertificates.isEmpty()) {
            gatherPeopleDeathCertificateInformantTimeLineData.gather(deathCertificates);
        }
    }

}
