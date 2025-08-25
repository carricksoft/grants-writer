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
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateBrideTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateBrideTimeLineDataImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherMarriageCertificateBrideTimeLineDataAddRankTest {

    GatherMarriageCertificateBrideTimeLineData gatherMarriageCertificateBrideTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    private List<MarriageCertificate> marriageCertificates;

    private TreeMap<DMY, List<String>> timeLine;

    private Person bride;

    private Person groom;

    private String rank;

    private MarriageCertificate marriageCertificate;


    @BeforeEach
    void setUp() {
        gatherMarriageCertificateBrideTimeLineData = new GatherMarriageCertificateBrideTimeLineDataImpl(this.timelineDataMock);
        marriageCertificates = new ArrayList<>();

        marriageCertificate = new MarriageCertificate();
        timeLine = new TreeMap<>();
        bride = GetRandomPerson();
        groom = GetRandomPerson();
        rank = GetRandomString();

    }

    private void setUpCertificate(String brideRank) {
        marriageCertificate.setWhenMarried("25/01/1953");
        marriageCertificate.setBride(bride);
        marriageCertificate.setGroom(groom);
        marriageCertificate.setBrideRank(brideRank);
        marriageCertificates.add(marriageCertificate);

    }

    @Test
    void addValidRankTest() {
        setUpCertificate(rank);
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        gatherMarriageCertificateBrideTimeLineData.gather(marriageCertificates);
        String expected = "Rank registered as " + rank;
        assertTrue(timeLine.firstEntry().getValue().contains(expected));
    }

    @Test
    void addNullRankTest() {
        setUpCertificate(null);
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        gatherMarriageCertificateBrideTimeLineData.gather(marriageCertificates);
        assertFalse(timeLine.firstEntry().getValue().contains("Rank"));
    }

    @Test
    void addEmptyRankTest() {
        setUpCertificate(ApplicationConstants.EMPTY_STRING);
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        gatherMarriageCertificateBrideTimeLineData.gather(marriageCertificates);
        assertFalse(timeLine.firstEntry().getValue().contains("Rank"));
    }



}