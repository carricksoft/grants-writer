/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.deathcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Organisation;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class GatherDeathCertificateInformantTimeLineDataRefsTest {

    GatherDeathCertificateInformantTimeLineData gatherDeathCertificateInformantTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    @Mock
    private Person personMock;

    private List<DeathCertificate> deathCertificates;

    private Organisation registrationAuthority;

    @BeforeEach
    void setUp() {
        gatherDeathCertificateInformantTimeLineData = new GatherDeathCertificateInformantTimeLineDataImpl(this.timelineDataMock);
        deathCertificates = new ArrayList<>();
        registrationAuthority = new Organisation();
    }

    @Test
    void refsAreAddedTest() {
        SortedSet<String> refs = new TreeSet<>();
        when(timelineDataMock.getRefs()).thenReturn(refs);
        DeathCertificate deathCertificate = new DeathCertificate();
        deathCertificate.setDeceased(personMock);
        deathCertificate.setWhenDied("25/01/1953 01:01");
        deathCertificate.setRegistrationAuthority(registrationAuthority);
        deathCertificates.add(deathCertificate);
        String toString = GetRandomString();
        when(personMock.toString()).thenReturn(toString);

        gatherDeathCertificateInformantTimeLineData.gather(deathCertificates);
        assertEquals("Death Certificate for : " + toString, refs.first());
    }

}