/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.deathcertificate.DeathCertificateService;


@Component
public class GatherDeathCertificateTimeLineDataImpl implements GatherDeathCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherDeathCertificateTimeLineDataImpl.class);

    private final DeathCertificateService deathCertificateService;

    public GatherDeathCertificateTimeLineDataImpl(DeathCertificateService deathCertificateService) {
        this.deathCertificateService = deathCertificateService;
    }

    @Override
    public void gather(Person person) {
       logger.debug("GatherDeathCertificateTimeLineDataImpl::gather");
    }

}
