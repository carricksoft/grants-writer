/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grantswriter.converters.StringToDMYConverter;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;

import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class AddWitnessDetailsTest {

    private AddWitnessDetails addWitnessDetails;

    @Mock
    private StringToDMYConverter stringToDMYConverterMock;

    @SuppressWarnings("unused")
    @BeforeEach
    public void setUp() {
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        TreeMap<DMY, List<String>> timeLine = new TreeMap<>();
        addWitnessDetails = new AddWitnessDetailsImpl(stringToDMYConverterMock);
    }

    @Test
    void constructorTest() {
       assertNotNull(addWitnessDetails);
    }

}