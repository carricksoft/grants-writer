/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.converters.StringToDMYConverter;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
public class GatherDivorceCertificateFirstPartyTimeLineDataImpl implements GatherDivorceCertificateFirstPartyTimeLineData {

    private final TimeLineData timelineData;

    private final StringToDMYConverter stringToDMYConverter;

    private static final Logger logger = LogManager.getLogger(GatherDivorceCertificateFirstPartyTimeLineDataImpl.class);


    public GatherDivorceCertificateFirstPartyTimeLineDataImpl(TimeLineData timelineData, StringToDMYConverter stringToDMYConverter) {
        this.timelineData = timelineData;
        this.stringToDMYConverter = stringToDMYConverter;
    }


    @Override
    public void gather(List<DivorceCertificate> divorceCertificates) {
        logger.info("GatherMarriageCertificateFirstWitnessTimeLineDataImpl::Gather");
        for (DivorceCertificate divorceCertificate : divorceCertificates) {
            addDivorced(timelineData.getTimeLine(), divorceCertificate);
            addRefs(divorceCertificate);
        }
    }

    @SuppressWarnings("unused")
    private void addRefs(DivorceCertificate divorceCertificate) {
        timelineData.getRefs().add("Divorce Certificate for : " + divorceCertificate.getFirstParty() + " and " + divorceCertificate.getSecondParty());
    }

    private void addDivorced(TreeMap<DMY, List<String>> timeLine, DivorceCertificate divorceCertificate) {
        logger.info("GatherDivorceCertificateFirstPartyTimeLineDataImpl::AddDivorce");
        List<String> existingValues = timeLine.get(stringToDMYConverter.convert(divorceCertificate.getRegisteredDate()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add("Divorced " + divorceCertificate.getSecondParty());

        timeLine.put(stringToDMYConverter.convert(divorceCertificate.getRegisteredDate()), existingValues);

    }

}
