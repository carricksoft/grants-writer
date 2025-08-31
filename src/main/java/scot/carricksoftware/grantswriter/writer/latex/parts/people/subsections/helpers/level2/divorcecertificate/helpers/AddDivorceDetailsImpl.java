/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.converters.StringToDMYConverter;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
public class AddDivorceDetailsImpl implements AddDivorceDetails {

    private final StringToDMYConverter stringToDMYConverter;

    public AddDivorceDetailsImpl(StringToDMYConverter stringToDMYConverter) {
        this.stringToDMYConverter = stringToDMYConverter;
    }

    @Override
    public void addDivorceDetails(TreeMap<DMY, List<String>> timeLine, DivorceCertificate divorceCertificate) {
        List<String> existingValues = timeLine.get(stringToDMYConverter.convert(divorceCertificate.getRegisteredDate()));
        if (existingValues == null) {
            existingValues = new ArrayList<>();
        }

        existingValues.add("Witnessed the marriage of " + divorceCertificate.getFirstParty().toString() + " and " + divorceCertificate.getSecondParty().toString());

        timeLine.put(stringToDMYConverter.convert(divorceCertificate.getRegisteredDate()), existingValues);
    }

}
