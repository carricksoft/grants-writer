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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.GatherBirthCertificateFatherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.GatherBirthCertificateInformantTimeLineDataImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.GatherBirthCertificateMotherTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.GatherBirthCertificateNewBornTimeLineData;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherBirthCertificateTimeLineDataTest {

    private GatherBirthCertificateTimeLineData gatherBirthCertificateTimeLineData;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private GatherBirthCertificateNewBornTimeLineData gatherBirthCertificateNewBornTimeLineDataMock;

    @Mock
    private GatherBirthCertificateFatherTimeLineData gatherBirthCertificateFatherTimeLineDataMock;

    @Mock
    private GatherBirthCertificateMotherTimeLineData gatherBirthCertificateMotherTimeLineDataMock;

    @Mock
    private GatherBirthCertificateInformantTimeLineDataImpl gatherBirthCertificateInformantTimeLineData;

    @BeforeEach
    void setUp() {
        gatherBirthCertificateTimeLineData = new GatherBirthCertificateTimeLineDataImpl(
                birthCertificateServiceMock,
                gatherBirthCertificateNewBornTimeLineDataMock,
                gatherBirthCertificateFatherTimeLineDataMock,
                gatherBirthCertificateMotherTimeLineDataMock,
                gatherBirthCertificateInformantTimeLineData);
    }

    @Test
    void notNullTest() {
        List<BirthCertificate> birthCertificates = new ArrayList<>();
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificates.add(birthCertificate);
        Person person = GetRandomPerson();
        when(birthCertificateServiceMock.findAllByNewBorn(person)).thenReturn(birthCertificates);

        gatherBirthCertificateTimeLineData.gather(person);
        verify(gatherBirthCertificateNewBornTimeLineDataMock).gather(birthCertificates);
    }

    @Test
    void nullTest() {
        List<BirthCertificate> birthCertificates = new ArrayList<>();
        Person person = GetRandomPerson();
        when(birthCertificateServiceMock.findAllByNewBorn(person)).thenReturn(birthCertificates);

        gatherBirthCertificateTimeLineData.gather(person);
        verifyNoInteractions(gatherBirthCertificateNewBornTimeLineDataMock);
    }

    @Test
    void gatherBirthCertificateFatherIsCalledTest() {
        List<BirthCertificate> birthCertificates = new ArrayList<>();
        Person person = GetRandomPerson();
        when(birthCertificateServiceMock.findAllByFather(person)).thenReturn(birthCertificates);
        gatherBirthCertificateTimeLineData.gather(person);
        verify(gatherBirthCertificateFatherTimeLineDataMock).gather(birthCertificates);
    }

    @Test
    void gatherBirthCertificateMotherIsCalledTest() {
        List<BirthCertificate> birthCertificates = new ArrayList<>();
        Person person = GetRandomPerson();
        when(birthCertificateServiceMock.findAllByMother(person)).thenReturn(birthCertificates);
        gatherBirthCertificateTimeLineData.gather(person);
        verify(gatherBirthCertificateMotherTimeLineDataMock).gather(birthCertificates);
    }
}