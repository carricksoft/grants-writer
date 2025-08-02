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
public class GatherDeathCertificateInformantTimeLineDataImpl implements GatherDeathCertificateInformantTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherDeathCertificateInformantTimeLineDataImpl.class);

    public GatherDeathCertificateInformantTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<DeathCertificate> deathCertificates) {
        logger.info("GatherDeathCertificateInformantTimeLineDataImpl::Gather");
        for (DeathCertificate deathCertificate : deathCertificates) {
            addRegisteredTheDeath(timelineData.getTimeLine(), deathCertificate);
            addRefs(deathCertificate);
        }
    }

    @SuppressWarnings("unused")
    private void addRefs(DeathCertificate deathCertificate) {
        timelineData.getRefs().add("Death Certificate for : " + deathCertificate.getDeceased().toString());
    }


    @SuppressWarnings("unused")
    private void addRegisteredTheDeath(TreeMap<DMY, List<String>> timeLine, DeathCertificate deathCertificate) {
        logger.info("GatherDeathCertificateInformantTimeLineDataImpl::AddWhenRegistered");

        if (deathCertificate.getWhenRegistered() != null  && !deathCertificate.getWhenRegistered().isEmpty()) {

            List<String> existingValues = timeLine.get(getDMY(deathCertificate.getWhenRegistered()));
            if (existingValues == null) {
                existingValues = new ArrayList<>();
            }

            String whereRegistered;

            if (deathCertificate.getWhereRegistered() != null  && !deathCertificate.getWhereRegistered().isEmpty()) {
                whereRegistered = deathCertificate.getWhereRegistered();
            } else {
                whereRegistered = deathCertificate.getRegistrationAuthority().toString();
            }

            existingValues.add("Registered the death of " + deathCertificate.getDeceased() + " at " + whereRegistered);
            timeLine.put(getDMY(deathCertificate.getWhenRegistered()), existingValues);
        }
    }

    private DMY getDMY(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
