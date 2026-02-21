/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.deathcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class GatherPlaceDeathCertificateWhereDiedTimeLineDataTest {

    GatherPlaceDeathCertificateWhereDiedTimeLineData gatherPlaceDeathCertificateWhereDiedTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    private List<DeathCertificate> deathCertificates;

    private TreeMap<DMY, List<String>> timeLine;

    private Person person;

    @BeforeEach
    void setUp() {
        gatherPlaceDeathCertificateWhereDiedTimeLineData = new GatherPlaceDeathCertificateWhereDiedTimeLineDataImpl(this.timelineDataMock);
        person = GetRandomPerson();
        deathCertificates = new ArrayList<>();

        DeathCertificate deathCertificate = new DeathCertificate();
        setUpDeathCertificate(deathCertificate);
        deathCertificates.add(deathCertificate);
        timeLine = new TreeMap<>();

    }

    private void setUpDeathCertificate(DeathCertificate deathCertificate) {
        deathCertificate.setWhereDied(GetRandomPlace());
        deathCertificate.setWhenDied("25/02/1953 01:01");
        deathCertificate.setDeceased(person);
    }

    @Test
    void whereDiedTest() {
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        String required = person.toString() + " Died here.";
        gatherPlaceDeathCertificateWhereDiedTimeLineData.gather(deathCertificates);
        assertTrue(timeLine.firstEntry().getValue().contains(required));
    }

    @Test
    void AddRefsTest() {
        SortedSet<String> refs = new TreeSet<>();
        when(timelineDataMock.getRefs()).thenReturn(refs);

        gatherPlaceDeathCertificateWhereDiedTimeLineData.gather(deathCertificates);
        assertEquals("Death Certificate for : " + person.toString(), refs.first());
    }
}

