/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.places.Place;


@Component
public class GatherPlaceTimeLineDataImpl implements GatherPlaceTimeLineData {

    private final GatherPlaceCensusTimeLineData gatherPlaceCensusTimeLineData;
    private final GatherPlaceBirthCertificateTimeLineData gatherPlaceBirthCertificateTimeLineData;
    private final GatherPlaceDeathCertificateTimeLineData gatherPlaceDeathCertificateTimeLineData;
    private final GatherPlaceMarriageCertificateTimeLineData gatherPlaceMarriageCertificateTimeLineData;

    @Autowired
    public GatherPlaceTimeLineDataImpl(
            GatherPlaceCensusTimeLineData gatherPlaceCensusTimeLineData, 
            GatherPlaceBirthCertificateTimeLineData gatherPlaceBirthCertificateTimeLineData,
            GatherPlaceDeathCertificateTimeLineData gatherPlaceDeathCertificateTimeLineData, 
            GatherPlaceMarriageCertificateTimeLineData gatherPlaceMarriageCertificateTimeLineData) {
        this.gatherPlaceCensusTimeLineData = gatherPlaceCensusTimeLineData;
        this.gatherPlaceBirthCertificateTimeLineData = gatherPlaceBirthCertificateTimeLineData;
        this.gatherPlaceDeathCertificateTimeLineData = gatherPlaceDeathCertificateTimeLineData;
        this.gatherPlaceMarriageCertificateTimeLineData = gatherPlaceMarriageCertificateTimeLineData;
    }

    @Override
    public void gather(Place place) {
   //    gatherPlaceCensusTimeLineData.gather(place);
   //    gatherPlaceBirthCertificateTimeLineData.gather(place);
   //    gatherPlaceDeathCertificateTimeLineData.gather(place);
       gatherPlaceMarriageCertificateTimeLineData.gather(place);
    }
}
