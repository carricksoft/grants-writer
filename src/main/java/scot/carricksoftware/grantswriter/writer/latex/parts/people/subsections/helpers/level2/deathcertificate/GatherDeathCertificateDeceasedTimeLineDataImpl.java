/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.deathcertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.DMYImpl;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
public class GatherDeathCertificateDeceasedTimeLineDataImpl implements GatherDeathCertificateDeceasedTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherDeathCertificateDeceasedTimeLineDataImpl.class);

    public GatherDeathCertificateDeceasedTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<DeathCertificate> deathCertificates) {
        logger.info("GatherDeathCertificateDeceasedTimeLineDataImpl::Gather");
        for (DeathCertificate deathCertificate : deathCertificates) {
            addWhenDied(timelineData.getTimeLine(), deathCertificate);
            addWhereRegistered(timelineData.getTimeLine(), deathCertificate);
            addRefs(deathCertificate);
        }
    }

    private void addRefs(DeathCertificate deathCertificate) {
        timelineData.getRefs().add("Death Certificate for : " + deathCertificate.getDeceased().toString());
    }

    private void addWhenDied(TreeMap<DMY, List<String>> timeLine, DeathCertificate deathCertificate) {
        logger.info("GatherDeathCertificateDeceasedTimeLineDataImpl::AddWhenDied");

        List<String> existingValues = timeLine.get(getDMY(deathCertificate.getWhenDied()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        if (deathCertificate.getWhereDied() != null) {
            existingValues.add("Died at " + deathCertificate.getWhereDied().toString());
        } else {
            existingValues.add("Died at " + deathCertificate.getUntrackedWhereDied());
        }
        timeLine.put(getDMY(deathCertificate.getWhenDied()), existingValues);

    }

    private void addWhereRegistered(TreeMap<DMY, List<String>> timeLine, DeathCertificate deathCertificate) {
        logger.info("GatherDeathCertificateDeceasedTimeLineDataImpl::AddWhenRegistered");

        if (deathCertificate.getWhenRegistered() != null  && !deathCertificate.getWhenRegistered().isEmpty()) {

            List<String> existingValues = timeLine.get(getDMY(deathCertificate.getWhenRegistered()));
            if (existingValues == null) {
                existingValues = new ArrayList<>();
            }

            String informant;
            String whereRegistered;

            if (deathCertificate.getWhereRegistered() != null  && !deathCertificate.getWhereRegistered().isEmpty()) {
                whereRegistered = deathCertificate.getWhereRegistered();
            } else {
                whereRegistered = deathCertificate.getRegistrationAuthority().toString();
            }

            if (deathCertificate.getInformant() != null) {
                informant= deathCertificate.getInformant().toString();
            } else {
                informant = deathCertificate.getUntrackedInformant();
            }
            existingValues.add("Death registered by " + informant + " at " + whereRegistered);
            timeLine.put(getDMY(deathCertificate.getWhenRegistered()), existingValues);
        }
    }

    private DMY getDMY(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
