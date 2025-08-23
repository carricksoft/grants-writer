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
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateBrideTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateBrideTimeLineDataImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherMarriageCertificateBrideTimeLineDataRefsTest {

    GatherMarriageCertificateBrideTimeLineData gatherMarriageCertificateBrideTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;


    private List<MarriageCertificate> marriageCertificates;

    private Person bride;
    private Person groom;

    @BeforeEach
    void setUp() {
        gatherMarriageCertificateBrideTimeLineData = new GatherMarriageCertificateBrideTimeLineDataImpl(this.timelineDataMock);
        marriageCertificates = new ArrayList<>();
        bride = GetRandomPerson();
        groom = GetRandomPerson();
    }

    @Test
    void refsAreAddedTest() {
        SortedSet<String> refs = new TreeSet<>();
        refs.add("MarriageCertificate");
        when(timelineDataMock.getRefs()).thenReturn(refs);
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setBride(bride);
        marriageCertificate.setGroom(groom);
        marriageCertificate.setWhenMarried("25/01/1953");
        marriageCertificates.add(marriageCertificate);


        gatherMarriageCertificateBrideTimeLineData.gather(marriageCertificates);
        assertEquals("Marriage Certificate for : " + bride.toString() + " and " + groom.toString(), refs.first());
    }
}