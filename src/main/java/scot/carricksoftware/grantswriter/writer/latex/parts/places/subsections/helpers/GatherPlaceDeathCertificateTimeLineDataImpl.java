/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.certificates.deathcertificate.DeathCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.deathcertificate.GatherPlaceDeathCertificateWhereDiedTimeLineData;

import java.util.List;


@Component
public class GatherPlaceDeathCertificateTimeLineDataImpl implements GatherPlaceDeathCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherPlaceDeathCertificateTimeLineDataImpl.class);

    private final DeathCertificateService deathCertificateService;
    private final GatherPlaceDeathCertificateWhereDiedTimeLineData gatherPlaceDeathCertificateWhereDiedTimeLineData;

    public GatherPlaceDeathCertificateTimeLineDataImpl(DeathCertificateService deathCertificateService,
                                                       GatherPlaceDeathCertificateWhereDiedTimeLineData gatherPlaceDeathCertificateWhereDiedTimeLineData) {
        this.deathCertificateService = deathCertificateService;
          this.gatherPlaceDeathCertificateWhereDiedTimeLineData = gatherPlaceDeathCertificateWhereDiedTimeLineData;
    }

    @Override
    public void gather(Place place) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gather");
        gatherWhereDied(place);
    }

    private void gatherWhereDied(Place place) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherDeceased");
       List<DeathCertificate> deathCertificates = deathCertificateService.findAllByWhereDied(place);
       if (!deathCertificates.isEmpty()) {
            gatherPlaceDeathCertificateWhereDiedTimeLineData.gather(deathCertificates);
        }
    }



}
