/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.helpers.AddDivorceDetails;


import java.util.List;
import java.util.TreeMap;

@Component
public class GatherDivorceCertificateFirstPartyTimeLineDataImpl implements GatherDivorceCertificateFirstPartyTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherDivorceCertificateFirstPartyTimeLineDataImpl.class);

    private final AddDivorceDetails addDivorceDetails;

    public GatherDivorceCertificateFirstPartyTimeLineDataImpl(TimeLineData timelineData, AddDivorceDetails addDivorceDetails) {
        this.timelineData = timelineData;
        this.addDivorceDetails = addDivorceDetails;
    }


    @Override
    public void gather(List<DivorceCertificate> divorceCertificates) {
        logger.info("GatherMarriageCertificateFirstWitnessTimeLineDataImpl::Gather");
        for (DivorceCertificate divorceCertificate : divorceCertificates) {
            addDivorced(timelineData.getTimeLine(), divorceCertificate);
            addRefs(divorceCertificate);
        }
    }

    @SuppressWarnings("unused")
    private void addRefs(DivorceCertificate divorceCertificate) {
        timelineData.getRefs().add("Divorce Certificate for : " + divorceCertificate.getFirstParty() + " and " + divorceCertificate.getSecondParty());
    }

    private void addDivorced(TreeMap<DMY, List<String>> timeLine, DivorceCertificate divorceCertificate) {
        logger.info("GatherDivorceCertificateFirstPartyTimeLineDataImpl::AddDivorce");
        addDivorceDetails.addDivorceDetails(timeLine, divorceCertificate);

    }

}
