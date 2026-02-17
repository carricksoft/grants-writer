/*
 * Copyright (c) 2025-2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.certificates.birthcertificate.BirthCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.birthcertificate.GatherPlaceBirthCertificateWhereBornTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.birthcertificate.GatherPlaceBirthCertificateWhereRegisteredTimeLineData;

import java.util.List;

@Component
public class GatherPlaceBirthCertificateTimeLineDataImpl implements GatherPlaceBirthCertificateTimeLineData {

    private final BirthCertificateService birthCertificateService;

    private final GatherPlaceBirthCertificateWhereBornTimeLineData gatherPlaceBirthCertificateWhereBornTimeLineData;

    private final GatherPlaceBirthCertificateWhereRegisteredTimeLineData gatherPlaceBirthCertificateWhereRegisteredTimeLineData;


    public GatherPlaceBirthCertificateTimeLineDataImpl(BirthCertificateService birthCertificateService,
                                                       GatherPlaceBirthCertificateWhereBornTimeLineData gatherPlaceBirthCertificateWhereBornTimeLineData,
                                                       GatherPlaceBirthCertificateWhereRegisteredTimeLineData gatherPlaceBirthCertificateWhereRegisteredTimeLineData) {
        this.birthCertificateService = birthCertificateService;
        this.gatherPlaceBirthCertificateWhereBornTimeLineData = gatherPlaceBirthCertificateWhereBornTimeLineData;
        this.gatherPlaceBirthCertificateWhereRegisteredTimeLineData = gatherPlaceBirthCertificateWhereRegisteredTimeLineData;
    }

    @Override
    public void gather(Place place) {
        gatherWhereBorn(place);
        gatherWhereRegistered(place);
    }

    private void gatherWhereBorn(Place place) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByWhereBorn(place);
        if (!birthCertificates.isEmpty()) {
            gatherPlaceBirthCertificateWhereBornTimeLineData.gather(birthCertificates);
        }
    }

    private void gatherWhereRegistered(Place place) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByWhereRegistered(place);
        gatherPlaceBirthCertificateWhereRegisteredTimeLineData.gather(birthCertificates);
    }


}
