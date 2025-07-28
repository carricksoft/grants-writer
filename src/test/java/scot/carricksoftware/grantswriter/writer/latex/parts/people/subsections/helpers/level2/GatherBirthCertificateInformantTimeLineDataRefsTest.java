/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherBirthCertificateInformantTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherBirthCertificateInformantTimeLineDataImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherBirthCertificateInformantTimeLineDataRefsTest {

    GatherBirthCertificateInformantTimeLineData gatherBirthCertificateInformantTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    @Mock
    private Person personMock;

    private List<BirthCertificate> birthCertificates;


    @BeforeEach
    void setUp() {
        gatherBirthCertificateInformantTimeLineData = new GatherBirthCertificateInformantTimeLineDataImpl(this.timelineDataMock);
        birthCertificates = new ArrayList<>();
    }

    @Test
    void refsAreAddedTest() {
        SortedSet<String> refs = new TreeSet<>();
        when(timelineDataMock.getRefs()).thenReturn(refs);
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificate.setNewBorn(personMock);
        birthCertificate.setWhenBorn("25/01/1953 01:01");
        birthCertificate.setWhenRegistered("25/01/1953 01:01");
        birthCertificate.setMother(GetRandomPerson());
        birthCertificate.setFather(GetRandomPerson());
        birthCertificates.add(birthCertificate);
        String toString = GetRandomString();
        when(personMock.toString()).thenReturn(toString);

        gatherBirthCertificateInformantTimeLineData.gather(birthCertificates);
        assertEquals("Birth Certificate for : " + toString, refs.first());

    }
}