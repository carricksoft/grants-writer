/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.helpers.AddWitnessDetails;

import java.util.List;
import java.util.TreeMap;

@Component
public class GatherPeopleMarriageCertificateFirstWitnessTimeLineDataImpl implements GatherPeopleMarriageCertificateFirstWitnessTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherPeopleMarriageCertificateFirstWitnessTimeLineDataImpl.class);

    private final AddWitnessDetails addWitnessDetails;

    @Autowired
    public GatherPeopleMarriageCertificateFirstWitnessTimeLineDataImpl(TimeLineData timelineData,
                                                                       AddWitnessDetails addWitnessDetails) {
        this.timelineData = timelineData;
        this.addWitnessDetails = addWitnessDetails;
    }

    @Override
    public void gather(List<MarriageCertificate> marriageCertificates) {
        logger.info("GatherMarriageCertificateFirstWitnessTimeLineDataImpl::Gather");
        for (MarriageCertificate marriageCertificate : marriageCertificates) {
            addWitnessed(timelineData.getTimeLine(), marriageCertificate);
            addRefs(marriageCertificate);
        }
    }

    private void addRefs(MarriageCertificate marriageCertificate) {
        timelineData.getRefs().add("Marriage Certificate for : " + marriageCertificate.getBride() + " and " + marriageCertificate.getGroom());
    }

    private void addWitnessed(TreeMap<DMY, List<String>> timeLine, MarriageCertificate marriageCertificate) {
        logger.info("GatherMarriageCertificateFirstWitnessTimeLineDataImpl::AddWitnessed");
        addWitnessDetails.addWitnessDetails(timeLine, marriageCertificate);

    }


}
