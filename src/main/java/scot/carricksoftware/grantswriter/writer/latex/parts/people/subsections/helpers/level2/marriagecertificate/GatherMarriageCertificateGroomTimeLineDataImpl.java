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
public class GatherMarriageCertificateGroomTimeLineDataImpl implements GatherMarriageCertificateGroomTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherMarriageCertificateGroomTimeLineDataImpl.class);

    public GatherMarriageCertificateGroomTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<MarriageCertificate> marriageCertificates) {
        logger.info("GatherMarriageCertificateGroomTimeLineDataImpl::Gather");
        for (MarriageCertificate marriageCertificate : marriageCertificates) {
            addWhenMarried(timelineData.getTimeLine(), marriageCertificate);
            addGroomRank(timelineData.getTimeLine(), marriageCertificate);
            addRefs(marriageCertificate);
        }
    }

    @SuppressWarnings("unused")
    private void addRefs(MarriageCertificate marriageCertificate) {
        timelineData.getRefs().add("Marriage Certificate for : " + marriageCertificate.getBride() + " and " + marriageCertificate.getGroom());
    }

    private void addWhenMarried(TreeMap<DMY, List<String>> timeLine, MarriageCertificate marriageCertificate) {
        logger.info("GatherMarriageCertificateGroomTimeLineDataImpl::AddWhenMarried");

        List<String> existingValues = timeLine.get(getDMY(marriageCertificate.getWhenMarried()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        if (marriageCertificate.getWhereMarried() != null) {
            existingValues.add("Married " + marriageCertificate.getBride().toString() + " at " + marriageCertificate.getWhereMarried().toString());
        } else {
            existingValues.add("Married " + marriageCertificate.getBride().toString() + " at " + marriageCertificate.getUntrackedWhereMarried());
        }
        timeLine.put(getDMY(marriageCertificate.getWhenMarried()), existingValues);
    }

    private void addGroomRank(TreeMap<DMY, List<String>> timeLine, MarriageCertificate marriageCertificate) {
        logger.info("GatherMarriageCertificateBrideTimeLineDataImpl::AddGroomRank");

        if (marriageCertificate.getGroomRank() != null  && !marriageCertificate.getGroomRank().isEmpty()) {
            List<String> existingValues = timeLine.get(getDMY(marriageCertificate.getWhenMarried()));
            if (existingValues == null) {
                existingValues = new ArrayList<>();
            }
            existingValues.add("Rank registered as " + marriageCertificate.getGroomRank());
            timeLine.put(getDMY(marriageCertificate.getWhenMarried()), existingValues);
        }
    }


    private DMY getDMY(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
