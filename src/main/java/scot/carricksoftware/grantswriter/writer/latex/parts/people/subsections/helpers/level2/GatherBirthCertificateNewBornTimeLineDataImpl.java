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
import java.util.SortedSet;
import java.util.TreeMap;

@Component
public class GatherBirthCertificateNewBornTimeLineDataImpl implements GatherBirthCertificateNewBornTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherBirthCertificateNewBornTimeLineDataImpl.class);

    public GatherBirthCertificateNewBornTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<BirthCertificate> birthCertificates) {
        logger.info("GatherBirthCertificateNewBornTimeLineDataImpl::Gather");
        for (BirthCertificate birthCertificate : birthCertificates) {
            addWhenBorn(timelineData.getTimeLine(), timelineData.getRefs(), birthCertificate);
            addWhenRegistered(timelineData.getTimeLine(), timelineData.getRefs(), birthCertificate);
            addMotherAndFather(timelineData.getTimeLine(), timelineData.getRefs(), birthCertificate);
        }
    }

    private void addWhenBorn(TreeMap<DMY, List<String>> timeLine, SortedSet<String> refs, BirthCertificate birthCertificate) {
        logger.info("GatherBirthCertificateNewBornTimeLineDataImpl::AddWhenBorn");

        List<String> existingValues = timeLine.get(getDMY(birthCertificate.getWhenBorn()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        if (birthCertificate.getWhereBorn() != null) {
            existingValues.add("Born at " + birthCertificate.getWhereBorn().toString());
        } else {
            existingValues.add("Born at " + birthCertificate.getUntrackedWhereBorn());
        }
        timeLine.put(getDMY(birthCertificate.getWhenBorn()), existingValues);

        refs.add("Birth Certificate for : " + birthCertificate.getNewBorn());
    }

    private void addWhenRegistered(TreeMap<DMY, List<String>> timeLine, SortedSet<String> refs, BirthCertificate birthCertificate) {
        logger.info("GatherBirthCertificateNewBornTimeLineDataImpl::AddWhenRegistered");

        List<String> existingValues = timeLine.get(getDMY(birthCertificate.getWhenRegistered()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        if (birthCertificate.getInformant() != null) {
            existingValues.add("Birth Registered by " + birthCertificate.getInformant().toString() + " at " + birthCertificate.getWhereRegistered());
        } else {
            existingValues.add("Birth Registered by " + birthCertificate.getUntrackedInformant() + " at " + birthCertificate.getWhereRegistered());
        }
        timeLine.put(getDMY(birthCertificate.getWhenRegistered()), existingValues);

    }

    private void addMotherAndFather(TreeMap<DMY, List<String>> timeLine, SortedSet<String> refs, BirthCertificate birthCertificate) {
        logger.info("GatherBirthCertificateNewBornTimeLineDataImpl::AddMotherAndFather");

        List<String> existingValues = timeLine.get(getDMY(birthCertificate.getWhenRegistered()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add("Mother Registered as " + birthCertificate.getMother().toString());
        existingValues.add("Father Registered as " + birthCertificate.getFather().toString());

       timeLine.put(getDMY(birthCertificate.getWhenRegistered()), existingValues);
    }

    private DMY getDMY(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
