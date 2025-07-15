/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2;

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
public class GatherBirthCertificateFatherTimeLineDataImpl implements GatherBirthCertificateFatherTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherBirthCertificateFatherTimeLineDataImpl.class);

    public GatherBirthCertificateFatherTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<BirthCertificate> birthCertificates) {
        logger.info("GatherBirthCertificateNewBornTimeLineDataImpl::Gather");
        for (BirthCertificate birthCertificate : birthCertificates) {
            addFather(timelineData.getTimeLine(), birthCertificate);
            addFatherOccupation(timelineData.getTimeLine(), birthCertificate);
            addRefs(birthCertificate);
        }
    }

    private void addFatherOccupation(TreeMap<DMY, List<String>> timeLine, BirthCertificate birthCertificate) {
        logger.info("GatherBirthCertificateFatherTimeLineDataImpl::AddFatherOccupation");

        List<String> existingValues = timeLine.get(getDMY(birthCertificate.getWhenBorn()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add("Occupation registered as " + birthCertificate.getFatherRank());
        timeLine.put(getDMY(birthCertificate.getWhenRegistered()), existingValues);

    }

    private void addRefs(BirthCertificate birthCertificate) {
        timelineData.getRefs().add("Birth Certificate for : " + birthCertificate.getNewBorn());
    }

    private void addFather(TreeMap<DMY, List<String>> timeLine, BirthCertificate birthCertificate) {
        logger.info("GatherBirthCertificateFatherTimeLineDataImpl::AddFather");

        List<String> existingValues = timeLine.get(getDMY(birthCertificate.getWhenRegistered()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add("Registered as the father of " + birthCertificate.getNewBorn());
        timeLine.put(getDMY(birthCertificate.getWhenRegistered()), existingValues);
    }

    private DMY getDMY(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
