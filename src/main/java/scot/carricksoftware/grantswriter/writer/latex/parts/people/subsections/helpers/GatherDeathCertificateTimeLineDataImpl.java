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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.deathcertificate.GatherDeathCertificateDeceasedTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.deathcertificate.GatherDeathCertificateInformantTimeLineData;

import java.util.List;


@Component
public class GatherDeathCertificateTimeLineDataImpl implements GatherDeathCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherDeathCertificateTimeLineDataImpl.class);

    private final DeathCertificateService deathCertificateService;
    private final GatherDeathCertificateDeceasedTimeLineData gatherDeathCertificateDeceasedTimeLineData;
    private final GatherDeathCertificateInformantTimeLineData gatherDeathCertificateInformantTimeLineData;

    public GatherDeathCertificateTimeLineDataImpl(DeathCertificateService deathCertificateService, GatherDeathCertificateDeceasedTimeLineData gatherDeathCertificateDeceasedTimeLineData, GatherDeathCertificateInformantTimeLineData gatherDeathCertificateInformantTimeLineData) {
        this.deathCertificateService = deathCertificateService;
        this.gatherDeathCertificateDeceasedTimeLineData = gatherDeathCertificateDeceasedTimeLineData;
        this.gatherDeathCertificateInformantTimeLineData = gatherDeathCertificateInformantTimeLineData;
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
            gatherDeathCertificateDeceasedTimeLineData.gather(deathCertificates);
        }
    }

    private void gatherInformant(Person person) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherInformant");
        List<DeathCertificate> deathCertificates = deathCertificateService.findAllByInformant(person);
        if (!deathCertificates.isEmpty()) {
            gatherDeathCertificateInformantTimeLineData.gather(deathCertificates);
        }
    }

}
