/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate;

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
public class GatherBirthCertificateInformantTimeLineDataImpl implements GatherBirthCertificateInformantTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherBirthCertificateInformantTimeLineDataImpl.class);

    public GatherBirthCertificateInformantTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<BirthCertificate> birthCertificates) {
        logger.info("GatherBirthCertificateInformantTimeLineDataImpl::Gather");
        for (BirthCertificate birthCertificate : birthCertificates) {
            addInformant(timelineData.getTimeLine(), birthCertificate);
            addRefs(birthCertificate);
        }
    }

    private void addInformant(TreeMap<DMY, List<String>> timeLine, BirthCertificate birthCertificate) {
        logger.info("GatherBirthCertificateInformantTimeLineDataImpl::AddMother");

        List<String> existingValues = timeLine.get(getDMY(birthCertificate.getWhenRegistered()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add("Registered the birth of " + birthCertificate.getNewBorn() + " at " + birthCertificate.getWhereRegistered());
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
