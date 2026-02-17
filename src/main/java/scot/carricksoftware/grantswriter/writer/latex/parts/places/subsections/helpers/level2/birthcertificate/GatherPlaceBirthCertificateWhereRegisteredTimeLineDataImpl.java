/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.birthcertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.DMYImpl;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
public class GatherPlaceBirthCertificateWhereRegisteredTimeLineDataImpl implements GatherPlaceBirthCertificateWhereRegisteredTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherPlaceBirthCertificateWhereRegisteredTimeLineDataImpl.class);

    public GatherPlaceBirthCertificateWhereRegisteredTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<BirthCertificate> birthCertificates) {
        logger.info("GatherBirthCertificateWhereRegisteredTimeLineDataImpl::Gather");
        for (BirthCertificate birthCertificate : birthCertificates) {
            addWhereRegistered(timelineData.getTimeLine(), birthCertificate);
            addRefs(birthCertificate);
        }
    }

    private void addWhereRegistered(TreeMap<DMY, List<String>> timeLine, BirthCertificate birthCertificate) {
        logger.info("GatherBirthCertificateFatherTimeLineDataImpl::AddWhereBorn");

        List<String> existingValues = timeLine.get(getDMY(birthCertificate.getWhenRegistered()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add("Birth of " + birthCertificate.getNewBorn() + " registered here. ");
        timeLine.put(getDMY(birthCertificate.getWhenRegistered()), existingValues);

    }

    private void addRefs(BirthCertificate birthCertificate) {
        timelineData.getRefs().add("Birth Certificate for : " + birthCertificate.getNewBorn());
    }


    private DMY getDMY(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
