/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.marriagecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class GatherPlaceMarriageCertificateWhereMarriedTimeLineDataTest {

    GatherPlaceMarriageCertificateWhereMarriedTimeLineData gatherPlaceMarriageCertificateWhereMarriedTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    private List<MarriageCertificate> marriageCertificates;

    private TreeMap<DMY, List<String>> timeLine;

    private Person groom;

    private Person bride;

    @BeforeEach
    void setUp() {
        gatherPlaceMarriageCertificateWhereMarriedTimeLineData = new GatherPlaceMarriageCertificateWhereMarriedTimeLineDataImpl(this.timelineDataMock);
        groom = GetRandomPerson();
        bride = GetRandomPerson();
        marriageCertificates = new ArrayList<>();

        MarriageCertificate marriageCertificate = new MarriageCertificate();
        setUpMarriageCertificate(marriageCertificate);
        marriageCertificates.add(marriageCertificate);
        timeLine = new TreeMap<>();
    }

    private void setUpMarriageCertificate(MarriageCertificate marriageCertificate) {
        marriageCertificate.setWhereMarried(GetRandomPlace());
        marriageCertificate.setWhenMarried("25/02/1953 01:01");
        marriageCertificate.setGroom(groom);
        marriageCertificate.setBride(bride);
    }

    @Test
    void whereBornTest() {
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        String required =  bride.toString() + "and " + groom.toString() + " Married here.";
        gatherPlaceMarriageCertificateWhereMarriedTimeLineData.gather(marriageCertificates);
        assertTrue(timeLine.firstEntry().getValue().contains(required));
    }

    @Test
    void AddRefsTest() {
        SortedSet<String> refs = new TreeSet<>();
        when(timelineDataMock.getRefs()).thenReturn(refs);

        gatherPlaceMarriageCertificateWhereMarriedTimeLineData.gather(marriageCertificates);
        String expected = "Marriage Certificate for : " + groom.toString() + " and " + bride.toString() + ".";
        assertEquals(expected, refs.first());
    }
}

