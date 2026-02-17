/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.certificates.deathcertificate.DeathCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.deathcertificate.GatherPlaceDeathCertificateWhereDiedTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.deathcertificate.GatherPlaceDeathCertificateWhereRegisteredTimeLineData;

import java.util.List;


@Component
public class GatherPlaceDeathCertificateTimeLineDataImpl implements GatherPlaceDeathCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherPlaceDeathCertificateTimeLineDataImpl.class);

    private final DeathCertificateService deathCertificateService;
    private final GatherPlaceDeathCertificateWhereDiedTimeLineData gatherPlaceDeathCertificateWhereDiedTimeLineData;
    private final GatherPlaceDeathCertificateWhereRegisteredTimeLineData gatherPlaceDeathCertificateWhereRegisteredTimeLineData;

    public GatherPlaceDeathCertificateTimeLineDataImpl(DeathCertificateService deathCertificateService,
                                                       GatherPlaceDeathCertificateWhereDiedTimeLineData gatherPlaceDeathCertificateWhereDiedTimeLineData,
                                                       GatherPlaceDeathCertificateWhereRegisteredTimeLineData gatherPlaceDeathCertificateWhereRegisteredTimeLineData) {
        this.deathCertificateService = deathCertificateService;
          this.gatherPlaceDeathCertificateWhereDiedTimeLineData = gatherPlaceDeathCertificateWhereDiedTimeLineData;
        this.gatherPlaceDeathCertificateWhereRegisteredTimeLineData = gatherPlaceDeathCertificateWhereRegisteredTimeLineData;
    }

    @Override
    public void gather(Place place) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gather");
        gatherWhereDied(place);
  //      gatherWhereRegistered(place);
    }

    private void gatherWhereDied(Place place) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherDeceased");
    //    List<DeathCertificate> deathCertificates = deathCertificateService.findAllByWhereDied(place);
     //   if (!deathCertificates.isEmpty()) {
    //        gatherPlaceDeathCertificateWhereDiedTimeLineData.gather(deathCertificates);
    //    }
    }

    private void gatherWhereRegistered(Place place) {
  //      logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherInformant");
  //      List<DeathCertificate> deathCertificates = deathCertificateService.findAllByWhereRegistered(place);
  //      if (!deathCertificates.isEmpty()) {
  //          gatherPlaceDeathCertificateWhereRegisteredTimeLineData.gather(deathCertificates);
     //   }
    }

}
