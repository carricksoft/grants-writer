/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherBirthCertificateFatherTimeLineDataFatherTest {

    GatherBirthCertificateFatherTimeLineData gatherBirthCertificateFatherTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    private List<BirthCertificate> birthCertificates;

    private TreeMap<DMY, List<String>> timeLine;

    private BirthCertificate birthCertificate;


    @BeforeEach
    void setUp() {
        gatherBirthCertificateFatherTimeLineData = new GatherBirthCertificateFatherTimeLineDataImpl(this.timelineDataMock);
        birthCertificates = new ArrayList<>();

        birthCertificate = new BirthCertificate();
        setUpBirthCertificate(birthCertificate);
        timeLine = new TreeMap<>();

    }

    private void setUpBirthCertificate(BirthCertificate birthCertificate) {
        birthCertificate.setWhenBorn("25/01/1953 01:01");
        birthCertificate.setWhenRegistered("25/01/1953 01:01");
        birthCertificate.setMother(GetRandomPerson());
    }

    @Test
    void fatherTest() {
        Person newBorn = GetRandomPerson();
        birthCertificate.setNewBorn(newBorn);
        birthCertificates.add(birthCertificate);

        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        gatherBirthCertificateFatherTimeLineData.gather(birthCertificates);
        String expected = "Registered as the father of " + newBorn;
        assertTrue(timeLine.firstEntry().getValue().contains(expected));
    }

    @Test
    void fatherRankTest() {
        Person newBorn = GetRandomPerson();
        String rank = GetRandomString();
        birthCertificate.setNewBorn(newBorn);
        birthCertificate.setFatherRank(rank);
        birthCertificates.add(birthCertificate);

        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        gatherBirthCertificateFatherTimeLineData.gather(birthCertificates);
        String expected = "Occupation registered as " + rank;
        assertTrue(timeLine.firstEntry().getValue().contains(expected));
    }

}