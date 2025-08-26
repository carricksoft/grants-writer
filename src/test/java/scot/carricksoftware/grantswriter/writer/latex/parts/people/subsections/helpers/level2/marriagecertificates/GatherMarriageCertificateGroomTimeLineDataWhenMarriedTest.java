/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.converters.StringToDMYConverter;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.DMYImpl;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateGroomTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateGroomTimeLineDataImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class GatherMarriageCertificateGroomTimeLineDataWhenMarriedTest {

    GatherMarriageCertificateGroomTimeLineData gatherMarriageCertificateGroomTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    @Mock
    private StringToDMYConverter stringToDMYConverterMock;

    private List<MarriageCertificate> marriageCertificates;

    private TreeMap<DMY, List<String>> timeLine;

    private Person bride;

    private Person groom;

    private Place whereMarried;

    private String untrackedPlace;

    private MarriageCertificate marriageCertificate;


    @BeforeEach
    void setUp() {
        gatherMarriageCertificateGroomTimeLineData = new GatherMarriageCertificateGroomTimeLineDataImpl(
                timelineDataMock,
                stringToDMYConverterMock);
        marriageCertificates = new ArrayList<>();

        marriageCertificate = new MarriageCertificate();
        timeLine = new TreeMap<>();
        bride = GetRandomPerson();
        groom = GetRandomPerson();
        whereMarried = GetRandomPlace();
        untrackedPlace = GetRandomString();
        setUpBaseCertificate();
        DMY dmy = new DMYImpl();
        dmy.parse("25/01/1953");
        when(stringToDMYConverterMock.convert(anyString())).thenReturn(dmy);
    }

    private void setUpBaseCertificate() {
        marriageCertificate.setWhenMarried("25/01/1953");
        marriageCertificate.setBride(bride);
        marriageCertificate.setGroom(groom);
        marriageCertificate.setWhereMarried(whereMarried);

    }

    private void setUpTrackedCertificate() {
        setUpBaseCertificate();
        marriageCertificate.setWhereMarried(whereMarried);
        marriageCertificates.add(marriageCertificate);
    }

    private void setUpUntrackedCertificate() {
        setUpBaseCertificate();
        marriageCertificate.setWhereMarried(null);
        marriageCertificate.setUntrackedWhereMarried(untrackedPlace);
        marriageCertificates.add(marriageCertificate);
    }

    @Test
    void whereMarriedTest() {
        setUpTrackedCertificate();
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        gatherMarriageCertificateGroomTimeLineData.gather(marriageCertificates);
        String expected = "Married " + bride.toString() + " at " + whereMarried.toString();
        assertTrue(timeLine.firstEntry().getValue().contains(expected));
    }

    @Test
    void untrackedWhereMarriedTest() {
        setUpUntrackedCertificate();
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        gatherMarriageCertificateGroomTimeLineData.gather(marriageCertificates);
        String expected = "Married " + bride.toString() + " at " + untrackedPlace;
        assertTrue(timeLine.firstEntry().getValue().contains(expected));
    }



}