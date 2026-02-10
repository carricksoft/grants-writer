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
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.marriagecertificate.MarriageCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherPeopleMarriageCertificateBrideTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherPeopleMarriageCertificateFirstWitnessTimeLineDataImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherPeopleMarriageCertificateGroomTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherPeopleMarriageCertificateSecondWitnessTimeLineDataImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherMarriageCertificateBrideAndGroomTimeLineDataTest {

    private GatherPeopleMarriageCertificateTimeLineData gatherPeopleMarriageCertificateTimeLineData;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;
    @Mock
    private GatherPeopleMarriageCertificateBrideTimeLineData gatherPeopleMarriageCertificateBrideTimeLineDataMock;
    @Mock
    private GatherPeopleMarriageCertificateGroomTimeLineData gatherPeopleMarriageCertificateGroomTimeLineDataMock;
    @Mock
    private GatherPeopleMarriageCertificateFirstWitnessTimeLineDataImpl gatherMarriageCertificateFirstWitnessTimeLineData;
    @Mock
    private GatherPeopleMarriageCertificateSecondWitnessTimeLineDataImpl gatherMarriageCertificateSecondWitnessTimeLineData;

    List<MarriageCertificate> marriageCertificates;
    Person person;

    @BeforeEach
    void setUp() {
        gatherPeopleMarriageCertificateTimeLineData = new GatherPeopleMarriageCertificateTimeLineDataImpl(
                marriageCertificateServiceMock,
                gatherPeopleMarriageCertificateBrideTimeLineDataMock,
                gatherPeopleMarriageCertificateGroomTimeLineDataMock,
                gatherMarriageCertificateFirstWitnessTimeLineData,
                gatherMarriageCertificateSecondWitnessTimeLineData);
        marriageCertificates = new ArrayList<>();

        person = GetRandomPerson();
    }

    @Test
    void notNullTest() {
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setBride(GetRandomPerson());
        marriageCertificates.add(marriageCertificate);
        when(marriageCertificateServiceMock.findAllByBride(person)).thenReturn(marriageCertificates);

        gatherPeopleMarriageCertificateTimeLineData.gather(person);
        verify(gatherPeopleMarriageCertificateBrideTimeLineDataMock).gather(marriageCertificates);
    }

    @Test
    void nullTest() {
        when(marriageCertificateServiceMock.findAllByBride(person)).thenReturn(marriageCertificates);
        gatherPeopleMarriageCertificateTimeLineData.gather(person);
        verifyNoInteractions(gatherPeopleMarriageCertificateBrideTimeLineDataMock);
    }

    @Test
    void gatherMarriageCertificateBrideIsCalledTest() {
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setBride(GetRandomPerson());
        marriageCertificates.add(marriageCertificate);
        when(marriageCertificateServiceMock.findAllByBride(person)).thenReturn(marriageCertificates);
        gatherPeopleMarriageCertificateTimeLineData.gather(person);
        verify(gatherPeopleMarriageCertificateBrideTimeLineDataMock).gather(marriageCertificates);
    }

    @Test
    void gatherMarriageCertificateGroomIsCalledTest() {
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setGroom(GetRandomPerson());
        marriageCertificates.add(marriageCertificate);
        when(marriageCertificateServiceMock.findAllByGroom(person)).thenReturn(marriageCertificates);
        gatherPeopleMarriageCertificateTimeLineData.gather(person);
        verify(gatherPeopleMarriageCertificateGroomTimeLineDataMock).gather(marriageCertificates);
    }


}