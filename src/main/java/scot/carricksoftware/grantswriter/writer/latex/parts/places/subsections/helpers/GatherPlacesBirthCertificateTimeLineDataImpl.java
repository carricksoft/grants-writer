/*
 * Copyright (c) 2025-2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.birthcertificate.BirthCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.birthcertificate.GatherPlacesBirthCertificateWhereBornTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.birthcertificate.GatherPlacesBirthCertificateWhereRegisteredTimeLineData;

import java.util.List;

@Component
public class GatherPlacesBirthCertificateTimeLineDataImpl implements GatherPlacesBirthCertificateTimeLineData {

    private final BirthCertificateService birthCertificateService;

    private final GatherPlacesBirthCertificateWhereBornTimeLineData gatherPlacesBirthCertificateWhereBornTimeLineData;

    private final GatherPlacesBirthCertificateWhereRegisteredTimeLineData gatherPlacesBirthCertificateWhereRegisteredTimeLineData;


    public GatherPlacesBirthCertificateTimeLineDataImpl(BirthCertificateService birthCertificateService,
                                                        GatherPlacesBirthCertificateWhereBornTimeLineData gatherPlacesBirthCertificateWhereBornTimeLineData,
                                                        GatherPlacesBirthCertificateWhereRegisteredTimeLineData gatherPlacesBirthCertificateWhereRegisteredTimeLineData) {
        this.birthCertificateService = birthCertificateService;
        this.gatherPlacesBirthCertificateWhereBornTimeLineData = gatherPlacesBirthCertificateWhereBornTimeLineData;
        this.gatherPlacesBirthCertificateWhereRegisteredTimeLineData = gatherPlacesBirthCertificateWhereRegisteredTimeLineData;
    }


    @Override
    public void gather(Person person) {
        gatherWhereBorn(person);
        gatherWhereRegistered(person);
    }

    private void gatherWhereBorn(Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByNewBorn(person);
        if (!birthCertificates.isEmpty()) {
            gatherPlacesBirthCertificateWhereBornTimeLineData.gather(birthCertificates);
        }
    }

    private void gatherWhereRegistered(Person person) {
        List<BirthCertificate> birthCertificates = birthCertificateService.findAllByFather(person);
        gatherPlacesBirthCertificateWhereRegisteredTimeLineData.gather(birthCertificates);
    }


}
