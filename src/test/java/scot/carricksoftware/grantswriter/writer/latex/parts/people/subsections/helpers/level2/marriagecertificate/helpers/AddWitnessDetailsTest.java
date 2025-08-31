/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.converters.StringToDMYConverter;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.DMYImpl;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
public class AddWitnessDetailsTest {

    private AddWitnessDetails addWitnessDetails;

    @Mock
    private StringToDMYConverter stringToDMYConverterMock;

    private TreeMap<DMY, List<String>> timeLine;

    private MarriageCertificate marriageCertificate;

    private DMY dmy;

    private Person groom;

    private Person bride;


    @SuppressWarnings("unused")
    @BeforeEach
    public void setUp() {
        groom = GetRandomPerson();
        bride = GetRandomPerson();
        marriageCertificate = new MarriageCertificate();
        marriageCertificate.setWhenMarried("25/01/1953");
        marriageCertificate.setGroom(groom);
        marriageCertificate.setBride(bride);
        timeLine = new TreeMap<>();
        dmy = new DMYImpl();
        dmy.parse("25/01/1953");
        when(stringToDMYConverterMock.convert("25/01/1953")).thenReturn(dmy);
        addWitnessDetails = new AddWitnessDetailsImpl(stringToDMYConverterMock);
    }

    @Test
    void addWitnessDetailsTest() {
        String required = "Witnessed the marriage of " + groom.toString() + " and " + bride.toString();
        addWitnessDetails.addWitnessDetails(timeLine, marriageCertificate);
        List<String> list = timeLine.get(dmy);
        assertTrue(list.contains(required));
    }

}