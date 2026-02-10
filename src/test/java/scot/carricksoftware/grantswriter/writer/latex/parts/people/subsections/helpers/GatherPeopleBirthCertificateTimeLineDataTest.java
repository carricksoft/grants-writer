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
import scot.carricksoftware.grantswriter.domains.certificates.birthcertificate.BirthCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.birthcertificate.BirthCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherPeopleBirthCertificateFatherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherPeopleBirthCertificateInformantTimeLineDataImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherPeopleBirthCertificateMotherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.birthcertificate.GatherPeopleBirthCertificateNewBornTimeLineData;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherPeopleBirthCertificateTimeLineDataTest {

    private GatherPeopleBirthCertificateTimeLineData gatherPeopleBirthCertificateTimeLineData;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;
    @Mock
    private GatherPeopleBirthCertificateNewBornTimeLineData gatherPeopleBirthCertificateNewBornTimeLineDataMock;
    @Mock
    private GatherPeopleBirthCertificateFatherTimeLineData gatherPeopleBirthCertificateFatherTimeLineDataMock;
    @Mock
    private GatherPeopleBirthCertificateMotherTimeLineData gatherPeopleBirthCertificateMotherTimeLineDataMock;
    @Mock
    private GatherPeopleBirthCertificateInformantTimeLineDataImpl gatherBirthCertificateInformantTimeLineDataMock;

    List<BirthCertificate> birthCertificates;
    Person person;

    @BeforeEach
    void setUp() {
        gatherPeopleBirthCertificateTimeLineData = new GatherPeopleBirthCertificateTimeLineDataImpl(
                birthCertificateServiceMock,
                gatherPeopleBirthCertificateNewBornTimeLineDataMock,
                gatherPeopleBirthCertificateFatherTimeLineDataMock,
                gatherPeopleBirthCertificateMotherTimeLineDataMock,
                gatherBirthCertificateInformantTimeLineDataMock);
        birthCertificates = new ArrayList<>();

        person = GetRandomPerson();
    }

    @Test
    void notNullTest() {
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificates.add(birthCertificate);
        when(birthCertificateServiceMock.findAllByNewBorn(person)).thenReturn(birthCertificates);

        gatherPeopleBirthCertificateTimeLineData.gather(person);
        verify(gatherPeopleBirthCertificateNewBornTimeLineDataMock).gather(birthCertificates);
    }

    @Test
    void nullTest() {
        when(birthCertificateServiceMock.findAllByNewBorn(person)).thenReturn(birthCertificates);
        gatherPeopleBirthCertificateTimeLineData.gather(person);
        verifyNoInteractions(gatherPeopleBirthCertificateNewBornTimeLineDataMock);
    }

    @Test
    void gatherBirthCertificateFatherIsCalledTest() {
        when(birthCertificateServiceMock.findAllByFather(person)).thenReturn(birthCertificates);
        gatherPeopleBirthCertificateTimeLineData.gather(person);
        verify(gatherPeopleBirthCertificateFatherTimeLineDataMock).gather(birthCertificates);
    }

    @Test
    void gatherBirthCertificateMotherIsCalledTest() {
        when(birthCertificateServiceMock.findAllByMother(person)).thenReturn(birthCertificates);
        gatherPeopleBirthCertificateTimeLineData.gather(person);
        verify(gatherPeopleBirthCertificateMotherTimeLineDataMock).gather(birthCertificates);
    }

    @Test
    void gatherBirthCertificateInformantIsCalledTest() {
        when(birthCertificateServiceMock.findAllByInformant(person)).thenReturn(birthCertificates);
        gatherPeopleBirthCertificateTimeLineData.gather(person);
        verify(gatherBirthCertificateInformantTimeLineDataMock).gather(birthCertificates);
    }
}