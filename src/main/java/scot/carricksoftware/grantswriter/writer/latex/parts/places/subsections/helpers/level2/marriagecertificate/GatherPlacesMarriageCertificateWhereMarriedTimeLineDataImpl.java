/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.marriagecertificate;

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
public class GatherPlacesMarriageCertificateWhereMarriedTimeLineDataImpl implements GatherPlacesMarriageCertificateWhereMarriedTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherPlacesMarriageCertificateWhereMarriedTimeLineDataImpl.class);

    public GatherPlacesMarriageCertificateWhereMarriedTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<MarriageCertificate> marriageCertificates) {
        logger.info("GatherPlacesMarriageCertificateNewDiedTimeLineDataImpl::Gather");
        for (MarriageCertificate marriageCertificate : marriageCertificates) {
            addWhereMarried(timelineData.getTimeLine(), marriageCertificate);
            addRefs(marriageCertificate);
        }
    }

    private void addWhereMarried(TreeMap<DMY, List<String>> timeLine, MarriageCertificate marriageCertificate) {
        logger.info("GatherPlacesMarriageCertificateFatherTimeLineDataImpl::AddWhereMarried");

        List<String> existingValues = timeLine.get(getDMY(marriageCertificate.getWhereMarried().toString()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add(marriageCertificate.getBride() + "and " + marriageCertificate.getGroom() + " Married  here.");
        timeLine.put(getDMY(marriageCertificate.getWhenMarried()), existingValues);

    }

    private void addRefs(MarriageCertificate marriageCertificate) {
        timelineData.getRefs().add("Marriage Certificate for : " + marriageCertificate.getGroom()+ " and " + marriageCertificate.getBride() + ".");
    }



    private DMY getDMY(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
