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
public class GatherPlaceBirthCertificateWhereBornTimeLineDataImpl implements GatherPlaceBirthCertificateWhereBornTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherPlaceBirthCertificateWhereBornTimeLineDataImpl.class);

    public GatherPlaceBirthCertificateWhereBornTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<BirthCertificate> birthCertificates) {
        logger.info("GatherBirthCertificateNewBornTimeLineDataImpl::Gather");
        for (BirthCertificate birthCertificate : birthCertificates) {
            addWhereBorn(timelineData.getTimeLine(), birthCertificate);
            addRefs(birthCertificate);
        }
        var z = -1;
    }

    private void addWhereBorn(TreeMap<DMY, List<String>> timeLine, BirthCertificate birthCertificate) {
        logger.info("GatherBirthCertificateFatherTimeLineDataImpl::AddWhereBorn");

        List<String> existingValues = timeLine.get(getDMY(birthCertificate.getWhenBorn()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add(birthCertificate.getNewBorn() + " Born here.");
        timeLine.put(getDMY(birthCertificate.getWhenBorn()), existingValues);

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
