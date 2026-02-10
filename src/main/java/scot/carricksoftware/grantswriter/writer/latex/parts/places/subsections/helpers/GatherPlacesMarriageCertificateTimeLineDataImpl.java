/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.certificates.marriagecertificate.MarriageCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.marriagecertificate.GatherPlacesMarriageCertificateWhereMarriedTimeLineData;

import java.util.List;


@Component
public class GatherPlacesMarriageCertificateTimeLineDataImpl implements GatherPlacesMarriageCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherPlacesMarriageCertificateTimeLineDataImpl.class);

    private final MarriageCertificateService marriageCertificateService;
    private final GatherPlacesMarriageCertificateWhereMarriedTimeLineData gatherPlacesMarriageCertificateWhereMarriedTimeLineData;


    public GatherPlacesMarriageCertificateTimeLineDataImpl(MarriageCertificateService marriageCertificateService,
                                                           GatherPlacesMarriageCertificateWhereMarriedTimeLineData gatherPlacesMarriageCertificateWhereMarriedTimeLineData) {
        this.marriageCertificateService = marriageCertificateService;
        this.gatherPlacesMarriageCertificateWhereMarriedTimeLineData = gatherPlacesMarriageCertificateWhereMarriedTimeLineData;
    }

    @Override
    public void gather(Place place) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gather");
        gatherWhereMarried(place);
    }

    private void gatherWhereMarried(Place place) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherBride");
        List<MarriageCertificate> marriageCertificates = marriageCertificateService.findAllByWhereMarried(place);
        if (!marriageCertificates.isEmpty()) {
            gatherPlacesMarriageCertificateWhereMarriedTimeLineData.gather(marriageCertificates);
        }
    }


}
