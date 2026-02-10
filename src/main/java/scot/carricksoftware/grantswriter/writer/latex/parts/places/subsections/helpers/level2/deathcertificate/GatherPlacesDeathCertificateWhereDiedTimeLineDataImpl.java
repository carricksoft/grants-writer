/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.deathcertificate;

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
public class GatherPlacesDeathCertificateWhereDiedTimeLineDataImpl implements GatherPlacesDeathCertificateWhereDiedTimeLineData {

    private final TimeLineData timelineData;

    private static final Logger logger = LogManager.getLogger(GatherPlacesDeathCertificateWhereDiedTimeLineDataImpl.class);

    public GatherPlacesDeathCertificateWhereDiedTimeLineDataImpl(TimeLineData timelineData) {
        this.timelineData = timelineData;
    }

    @Override
    public void gather(List<DeathCertificate> deathCertificates) {
        logger.info("GatherPlacesBirthCertificateNewDiedTimeLineDataImpl::Gather");
        for (DeathCertificate deathCertificate : deathCertificates) {
            addWhereDied(timelineData.getTimeLine(), deathCertificate);
            addRefs(deathCertificate);
        }
    }

    private void addWhereDied(TreeMap<DMY, List<String>> timeLine, DeathCertificate deathCertificate) {
        logger.info("GatherPlacesDeathCertificateFatherTimeLineDataImpl::AddWhereDied");

        List<String> existingValues = timeLine.get(getDMY(deathCertificate.getWhereDied().toString()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add(deathCertificate.getDeceased() + " Died here.");
        timeLine.put(getDMY(deathCertificate.getWhereDied().toString()), existingValues);

    }

    private void addRefs(DeathCertificate deathCertificate) {
        timelineData.getRefs().add("Death Certificate for : " + deathCertificate.getDeceased());
    }



    private DMY getDMY(String dateKey) {
        DMY dmyKey = new DMYImpl();
        dmyKey.parse(dateKey);
        return dmyKey;
    }
}
