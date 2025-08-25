/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.DMYImpl;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
public class GatherMarriageCertificateFirstWitnessTimeLineDataImpl implements GatherMarriageCertificateFirstWitnessTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherMarriageCertificateFirstWitnessTimeLineDataImpl.class);

    public GatherMarriageCertificateFirstWitnessTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<MarriageCertificate> marriageCertificates) {
        logger.info("GatherMarriageCertificateFirstWitnessTimeLineDataImpl::Gather");
        for (MarriageCertificate marriageCertificate : marriageCertificates) {
            addWitnessed(timelineData.getTimeLine(), marriageCertificate);
            addRefs(marriageCertificate);
        }
    }

    @SuppressWarnings("unused")
    private void addRefs(MarriageCertificate marriageCertificate) {
        timelineData.getRefs().add("Marriage Certificate for : " + marriageCertificate.getBride() + " and " + marriageCertificate.getGroom());
    }

    private void addWitnessed(TreeMap<DMY, List<String>> timeLine, MarriageCertificate marriageCertificate) {
        logger.info("GatherMarriageCertificateFirstWitnessTimeLineDataImpl::AddWitnessed");

        List<String> existingValues = timeLine.get(getDMY(marriageCertificate.getWhenMarried()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add("Witnessed the marriage of " + marriageCertificate.getGroom().toString() + " and " + marriageCertificate.getBride().toString());

        timeLine.put(getDMY(marriageCertificate.getWhenMarried()), existingValues);

    }

    private DMY getDMY(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
