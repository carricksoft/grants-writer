/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Component
public class GatherTimeLineDataImpl implements GatherTimeLineData {

    private final GatherCensusTimeLineData gatherCensusTimeLineData;
    private final GatherBirthCertificateTimeLineData gatherBirthCertificateTimeLineData;
    private final GatherDeathCertificateTimeLineData gatherDeathCertificateTimeLineData;
    private final GatherMarriageCertificateTimeLineData gatherMarriageCertificateTimeLineData;
    private final GatherDivorceCertificateTimeLineData gatherDivorceCertificateTimeLineData;

    @Autowired
    public GatherTimeLineDataImpl(
            GatherCensusTimeLineData gatherCensusTimeLineData, GatherBirthCertificateTimeLineData gatherBirthCertificateTimeLineData, GatherDeathCertificateTimeLineData gatherDeathCertificateTimeLineData, GatherMarriageCertificateTimeLineData gatherMarriageCertificateTimeLineData, GatherDivorceCertificateTimeLineData gatherDivorceCertificateTimeLineData) {
        this.gatherCensusTimeLineData = gatherCensusTimeLineData;
        this.gatherBirthCertificateTimeLineData = gatherBirthCertificateTimeLineData;
        this.gatherDeathCertificateTimeLineData = gatherDeathCertificateTimeLineData;
        this.gatherMarriageCertificateTimeLineData = gatherMarriageCertificateTimeLineData;
        this.gatherDivorceCertificateTimeLineData = gatherDivorceCertificateTimeLineData;
    }

    @Override
    public void gather(Person person) {
        gatherCensusTimeLineData.gather(person);
        gatherBirthCertificateTimeLineData.gather(person);
        gatherDeathCertificateTimeLineData.gather(person);
        gatherMarriageCertificateTimeLineData.gather(person);
        gatherDivorceCertificateTimeLineData.gather(person);
    }
}
