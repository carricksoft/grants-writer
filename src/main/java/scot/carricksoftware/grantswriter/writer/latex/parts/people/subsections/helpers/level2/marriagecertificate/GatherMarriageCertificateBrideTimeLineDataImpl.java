/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.converters.StringToDMYConverter;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
public class GatherMarriageCertificateBrideTimeLineDataImpl implements GatherMarriageCertificateBrideTimeLineData {

    private final TimeLineData timelineData;

    private final StringToDMYConverter stringToDMYConverter;

    private static final Logger logger = LogManager.getLogger(GatherMarriageCertificateBrideTimeLineDataImpl.class);

    public GatherMarriageCertificateBrideTimeLineDataImpl(TimeLineData timelineData, StringToDMYConverter stringToDMYConverter) {
        this.timelineData = timelineData;
        this.stringToDMYConverter = stringToDMYConverter;
    }

    @Override
    public void gather(List<MarriageCertificate> marriageCertificates) {
        logger.info("GatherMarriageCertificateBrideTimeLineDataImpl::Gather");
        for (MarriageCertificate marriageCertificate : marriageCertificates) {
            addWhenMarried(timelineData.getTimeLine(), marriageCertificate);
            addBrideRank(timelineData.getTimeLine(), marriageCertificate);
            addRefs(marriageCertificate);
        }
    }

    @SuppressWarnings("unused")
    private void addRefs(MarriageCertificate marriageCertificate) {
        var vz = timelineData.getRefs();
        timelineData.getRefs().add("Marriage Certificate for : " + marriageCertificate.getBride() + " and " + marriageCertificate.getGroom());
        var vx = timelineData.getRefs();
        int deb = -1;
    }

    private void addWhenMarried(TreeMap<DMY, List<String>> timeLine, MarriageCertificate marriageCertificate) {
        logger.info("GatherMarriageCertificateBrideTimeLineDataImpl::AddWhenMarried");

        List<String> existingValues = timeLine.get(stringToDMYConverter.convert(marriageCertificate.getWhenMarried()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        if (marriageCertificate.getWhereMarried() != null) {
            existingValues.add("Married " + marriageCertificate.getGroom().toString() + " at " + marriageCertificate.getWhereMarried().toString());
        } else {
            existingValues.add("Married " + marriageCertificate.getGroom().toString() + " at " + marriageCertificate.getUntrackedWhereMarried());
        }
        timeLine.put(stringToDMYConverter.convert(marriageCertificate.getWhenMarried()), existingValues);
    }

    private void addBrideRank(TreeMap<DMY, List<String>> timeLine, MarriageCertificate marriageCertificate) {
        logger.info("GatherMarriageCertificateBrideTimeLineDataImpl::AddBrideRank");

        List<String> existingValues = timeLine.get(stringToDMYConverter.convert(marriageCertificate.getWhenMarried()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        if (marriageCertificate.getBrideRank() != null) {
            existingValues.add("Rank registered as " + marriageCertificate.getBrideRank());
        }
        timeLine.put(stringToDMYConverter.convert(marriageCertificate.getWhenMarried()), existingValues);
    }
}
