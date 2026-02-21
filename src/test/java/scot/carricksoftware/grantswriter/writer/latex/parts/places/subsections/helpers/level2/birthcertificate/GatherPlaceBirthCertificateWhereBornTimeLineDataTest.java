/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.birthcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class GatherPlaceBirthCertificateWhereBornTimeLineDataTest {

    GatherPlaceBirthCertificateWhereBornTimeLineData gatherPlaceBirthCertificateWhereBornTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    private List<BirthCertificate> birthCertificates;

    private TreeMap<DMY, List<String>> timeLine;

    private Person person;

    @BeforeEach
    void setUp() {
        gatherPlaceBirthCertificateWhereBornTimeLineData = new GatherPlaceBirthCertificateWhereBornTimeLineDataImpl(this.timelineDataMock);
        person = GetRandomPerson();
        birthCertificates = new ArrayList<>();

        BirthCertificate birthCertificate = new BirthCertificate();
        setUpBirthCertificate(birthCertificate);
        birthCertificates.add(birthCertificate);
        timeLine = new TreeMap<>();

    }

    private void setUpBirthCertificate(BirthCertificate birthCertificate) {
        birthCertificate.setWhereBorn(GetRandomPlace());
        birthCertificate.setWhenBorn("25/02/1953 01:01");
        birthCertificate.setNewBorn(person);
    }

    @Test
    void whereBornTest() {
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        String required = person.toString() + " Born here.";
        gatherPlaceBirthCertificateWhereBornTimeLineData.gather(birthCertificates);
        assertTrue(timeLine.firstEntry().getValue().contains(required));
    }

    @Test
    void AddRefsTest() {
        SortedSet<String> refs = new TreeSet<>();
        when(timelineDataMock.getRefs()).thenReturn(refs);

        gatherPlaceBirthCertificateWhereBornTimeLineData.gather(birthCertificates);
        assertEquals("Birth Certificate for : " + person.toString(), refs.first());

    }
}

