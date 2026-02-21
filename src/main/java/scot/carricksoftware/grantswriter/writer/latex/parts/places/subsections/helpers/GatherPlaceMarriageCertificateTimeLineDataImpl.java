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
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.marriagecertificate.GatherPlaceMarriageCertificateWhereMarriedTimeLineData;

import java.util.List;


@Component
public class GatherPlaceMarriageCertificateTimeLineDataImpl implements GatherPlaceMarriageCertificateTimeLineData {
    private static final Logger logger = LogManager.getLogger(GatherPlaceMarriageCertificateTimeLineDataImpl.class);

    private final MarriageCertificateService marriageCertificateService;
    private final GatherPlaceMarriageCertificateWhereMarriedTimeLineData gatherPlaceMarriageCertificateWhereMarriedTimeLineData;


    public GatherPlaceMarriageCertificateTimeLineDataImpl(MarriageCertificateService marriageCertificateService,
                                                          GatherPlaceMarriageCertificateWhereMarriedTimeLineData gatherPlaceMarriageCertificateWhereMarriedTimeLineData) {
        this.marriageCertificateService = marriageCertificateService;
        this.gatherPlaceMarriageCertificateWhereMarriedTimeLineData = gatherPlaceMarriageCertificateWhereMarriedTimeLineData;
    }

    @Override
    public void gather(Place place) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gather");
        gatherWhereMarried(place);
    }

    private void gatherWhereMarried(Place place) {
        logger.debug("GatherDeathCertificateTimeLineDataImpl::gatherWhereMarried");
        List<MarriageCertificate> marriageCertificates = marriageCertificateService.findAllByWhereMarried(place);
        if (!marriageCertificates.isEmpty()) {
            gatherPlaceMarriageCertificateWhereMarriedTimeLineData.gather(marriageCertificates);
        }
    }


}
