/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.converters.StringToDMYConverter;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
public class AddWitnessDetailsImpl implements AddWitnessDetails {

    private final StringToDMYConverter stringToDMYConverter;

    public AddWitnessDetailsImpl(StringToDMYConverter stringToDMYConverter) {
        this.stringToDMYConverter = stringToDMYConverter;
    }

    @Override
    public void addWitnessDetails(TreeMap<DMY, List<String>> timeLine, MarriageCertificate marriageCertificate) {
        List<String> existingValues = timeLine.get(stringToDMYConverter.convert(marriageCertificate.getWhenMarried()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add("Witnessed the marriage of " + marriageCertificate.getGroom().toString() + " and " + marriageCertificate.getBride().toString());

        timeLine.put(stringToDMYConverter.convert(marriageCertificate.getWhenMarried()), existingValues);
    }
}
