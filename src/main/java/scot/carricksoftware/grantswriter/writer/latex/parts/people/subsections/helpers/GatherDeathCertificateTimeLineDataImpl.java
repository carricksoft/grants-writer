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

import java.util.List;


@Component
public class GatherDeathCertificateTimeLineDataImpl implements GatherDeathCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherDeathCertificateTimeLineDataImpl.class);

    private final DeathCertificateService deathCertificateService;
    private final GatherDeathCertificateDeceasedTimeLineData gatherDeathCertificateDeceasedTimeLineData;

    public GatherDeathCertificateTimeLineDataImpl(DeathCertificateService deathCertificateService, GatherDeathCertificateDeceasedTimeLineData gatherDeathCertificateDeceasedTimeLineData) {
        this.deathCertificateService = deathCertificateService;
        this.gatherDeathCertificateDeceasedTimeLineData = gatherDeathCertificateDeceasedTimeLineData;
    }

    @Override
    public void gather(Person person) {
       logger.debug("GatherDeathCertificateTimeLineDataImpl::gather");
        List<DeathCertificate> deathCertificates = deathCertificateService.findAllByDeceased(person);
        if (!deathCertificates.isEmpty()) {
            gatherDeathCertificateDeceasedTimeLineData.gather(deathCertificates);
        }
    }

}
