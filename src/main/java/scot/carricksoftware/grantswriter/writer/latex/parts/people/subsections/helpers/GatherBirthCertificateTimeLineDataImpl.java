/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.birthcertificate.BirthCertificateService;

@Component
public class GatherBirthCertificateTimeLineDataImpl implements GatherBirthCertificateTimeLineData {

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final BirthCertificateService  birthCertificateService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final TimeLineData timelineData;

    public GatherBirthCertificateTimeLineDataImpl(BirthCertificateService birthCertificateService, TimeLineData timelineData) {
        this.birthCertificateService = birthCertificateService;
        this.timelineData = timelineData;
    }


    @Override
    public void gatherNewBorn(Person person) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void gatherFather(Person person) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void gatherMother(Person person) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void gatherInformant(Person person) {
        throw new UnsupportedOperationException();
    }
}
