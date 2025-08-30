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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.AddWitnessDetails;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateSecondWitnessTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateSecondWitnessTimeLineDataImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherMarriageCertificateSecondWitnessTimeLineDataRefsTest {

    GatherMarriageCertificateSecondWitnessTimeLineData gatherMarriageCertificateSecondWitnessTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    @Mock
    private AddWitnessDetails addWitnessDetailsMock;

    private List<MarriageCertificate> marriageCertificates;

    private Person bride;
    private Person groom;

    @BeforeEach
    void setUp() {
        gatherMarriageCertificateSecondWitnessTimeLineData = new GatherMarriageCertificateSecondWitnessTimeLineDataImpl(
                timelineDataMock,
                addWitnessDetailsMock);
        marriageCertificates = new ArrayList<>();
        bride = GetRandomPerson();
        groom = GetRandomPerson();
    }

    @Test
    void refsAreAddedTest() {
        SortedSet<String> refs = new TreeSet<>();
        refs.add(GetRandomString());
        when(timelineDataMock.getRefs()).thenReturn(refs);
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setBride(bride);
        marriageCertificate.setGroom(groom);
        marriageCertificate.setBrideRank("RandomQ");
        marriageCertificate.setWhenMarried("25/01/1953");
        marriageCertificates.add(marriageCertificate);

        gatherMarriageCertificateSecondWitnessTimeLineData.gather(marriageCertificates);
        assertTrue(refs.contains("Marriage Certificate for : " + bride.toString() + " and " + groom.toString()));
    }
}