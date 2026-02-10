/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.converters.StringToDMYConverter;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomDMYValues.GetRandomDMY;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherPeopleMarriageCertificateGroomTimeLineDataAddRankTest {

    GatherPeopleMarriageCertificateGroomTimeLineData gatherPeopleMarriageCertificateGroomTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    @Mock
    private StringToDMYConverter stringToDMYConverterMock;

    private List<MarriageCertificate> marriageCertificates;

    private TreeMap<DMY, List<String>> timeLine;

    private Person bride;

    private Person groom;

    private String rank;

    private MarriageCertificate marriageCertificate;


    @BeforeEach
    void setUp() {
        gatherPeopleMarriageCertificateGroomTimeLineData = new GatherPeopleMarriageCertificateGroomTimeLineDataImpl(
                timelineDataMock,
                stringToDMYConverterMock);
        marriageCertificates = new ArrayList<>();

        marriageCertificate = new MarriageCertificate();
        timeLine = new TreeMap<>();
        bride = GetRandomPerson();
        groom = GetRandomPerson();
        rank = GetRandomString();
        DMY dmy = GetRandomDMY();
        when(stringToDMYConverterMock.convert(anyString())).thenReturn(dmy);
    }

    private void setUpCertificate(String groomRank) {
        marriageCertificate.setWhenMarried("25/01/1953");
        marriageCertificate.setBride(bride);
        marriageCertificate.setGroom(groom);
        marriageCertificate.setGroomRank(groomRank);
        marriageCertificates.add(marriageCertificate);

    }

    @Test
    void addValidRankTest() {
        setUpCertificate(rank);
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        gatherPeopleMarriageCertificateGroomTimeLineData.gather(marriageCertificates);
        String expected = "Rank registered as " + rank;
        assertTrue(timeLine.firstEntry().getValue().contains(expected));
    }

    @Test
    void addNullRankTest() {
        setUpCertificate(null);
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        gatherPeopleMarriageCertificateGroomTimeLineData.gather(marriageCertificates);
        assertFalse(timeLine.firstEntry().getValue().contains("Rank"));
    }

    @Test
    void addEmptyRankTest() {
        setUpCertificate(ApplicationConstants.EMPTY_STRING);
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        gatherPeopleMarriageCertificateGroomTimeLineData.gather(marriageCertificates);
        assertFalse(timeLine.firstEntry().getValue().contains("Rank"));
    }


}