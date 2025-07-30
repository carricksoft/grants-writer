/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.deathcertificate.DeathCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.deathcertificate.GatherDeathCertificateDeceasedTimeLineData;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherDeathCertificateTimeLineDataTest {

    private GatherDeathCertificateTimeLineData gatherDeathCertificateTimeLineData;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private GatherDeathCertificateDeceasedTimeLineData gatherDeathCertificateNewBornTimeLineDataMock;


    List<DeathCertificate> deathCertificates;
    Person person;

    @BeforeEach
    void setUp() {
        gatherDeathCertificateTimeLineData = new GatherDeathCertificateTimeLineDataImpl(
                deathCertificateServiceMock,
                gatherDeathCertificateNewBornTimeLineDataMock);
        deathCertificates = new ArrayList<>();

        person = GetRandomPerson();
    }

    @Test
    void notDeceasedNullTest() {
        DeathCertificate deathCertificate = new DeathCertificate();
        deathCertificates.add(deathCertificate);
        when(deathCertificateServiceMock.findAllByDeceased(person)).thenReturn(deathCertificates);

        gatherDeathCertificateTimeLineData.gather(person);
        verify(gatherDeathCertificateNewBornTimeLineDataMock).gather(deathCertificates);
    }

    @Test
    void nullDeceasedTest() {
        when(deathCertificateServiceMock.findAllByDeceased(person)).thenReturn(deathCertificates);
        gatherDeathCertificateTimeLineData.gather(person);
        verifyNoInteractions(gatherDeathCertificateNewBornTimeLineDataMock);
    }

}