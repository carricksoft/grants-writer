/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Component
public class GatherPeopleTimeLineDataImpl implements GatherPeopleTimeLineData {

    private final GatherPeopleCensusTimeLineData gatherPeopleCensusTimeLineData;
    private final GatherPeopleBirthCertificateTimeLineData gatherPeopleBirthCertificateTimeLineData;
    private final GatherPeopleDeathCertificateTimeLineData gatherPeopleDeathCertificateTimeLineData;
    private final GatherPeopleMarriageCertificateTimeLineData gatherPeopleMarriageCertificateTimeLineData;
    private final GatherPeopleDivorceCertificateTimeLineData gatherPeopleDivorceCertificateTimeLineData;

    @Autowired
    public GatherPeopleTimeLineDataImpl(
            GatherPeopleCensusTimeLineData gatherPeopleCensusTimeLineData, GatherPeopleBirthCertificateTimeLineData gatherPeopleBirthCertificateTimeLineData, GatherPeopleDeathCertificateTimeLineData gatherPeopleDeathCertificateTimeLineData, GatherPeopleMarriageCertificateTimeLineData gatherPeopleMarriageCertificateTimeLineData, GatherPeopleDivorceCertificateTimeLineData gatherPeopleDivorceCertificateTimeLineData) {
        this.gatherPeopleCensusTimeLineData = gatherPeopleCensusTimeLineData;
        this.gatherPeopleBirthCertificateTimeLineData = gatherPeopleBirthCertificateTimeLineData;
        this.gatherPeopleDeathCertificateTimeLineData = gatherPeopleDeathCertificateTimeLineData;
        this.gatherPeopleMarriageCertificateTimeLineData = gatherPeopleMarriageCertificateTimeLineData;
        this.gatherPeopleDivorceCertificateTimeLineData = gatherPeopleDivorceCertificateTimeLineData;
    }

    @Override
    public void gather(Person person) {
        gatherPeopleCensusTimeLineData.gather(person);
        gatherPeopleBirthCertificateTimeLineData.gather(person);
        gatherPeopleDeathCertificateTimeLineData.gather(person);
        gatherPeopleMarriageCertificateTimeLineData.gather(person);
        gatherPeopleDivorceCertificateTimeLineData.gather(person);
    }
}
