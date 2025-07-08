/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Component
public class GatherTimeLineDataImpl implements GatherTimeLineData {

   private final GatherCensusTimeLineData gatherCensusTimeLineData;
    private final GatherBirthCertificateTimeLineData gatherBirthCertificateTimeLineData;

    public GatherTimeLineDataImpl(
            GatherCensusTimeLineData gatherCensusTimeLineData, GatherBirthCertificateTimeLineData gatherBirthCertificateTimeLineData) {
        this.gatherCensusTimeLineData = gatherCensusTimeLineData;
        this.gatherBirthCertificateTimeLineData = gatherBirthCertificateTimeLineData;
    }

    @Override
    public void gather(Person person) {
        gatherCensusTimeLineData.gather(person);
        gatherBirthCertificateTimeLineData.gather(person);
    }
}
