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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateBrideTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateGroomTimeLineData;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherMarriageCertificateTimeLineDataTest {

    private GatherMarriageCertificateTimeLineData gatherMarriageCertificateTimeLineData;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;

    @Mock
    private GatherMarriageCertificateBrideTimeLineData gatherMarriageCertificateBrideTimeLineDataMock;

    @Mock
    private GatherMarriageCertificateGroomTimeLineData gatherMarriageCertificateGroomTimeLineDataMock;

    List<MarriageCertificate> marriageCertificates;
    Person person;

    @BeforeEach
    void setUp() {
        gatherMarriageCertificateTimeLineData = new GatherMarriageCertificateTimeLineDataImpl(
                marriageCertificateServiceMock,
                gatherMarriageCertificateBrideTimeLineDataMock,
                gatherMarriageCertificateGroomTimeLineDataMock);
        marriageCertificates = new ArrayList<>();

        person = GetRandomPerson();
    }

    @Test
    void notNullTest() {
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setBride(GetRandomPerson());
        marriageCertificates.add(marriageCertificate);
        when(marriageCertificateServiceMock.findAllByBride(person)).thenReturn(marriageCertificates);

        gatherMarriageCertificateTimeLineData.gather(person);
        verify(gatherMarriageCertificateBrideTimeLineDataMock).gather(marriageCertificates);
    }

    @Test
    void nullTest() {
        when(marriageCertificateServiceMock.findAllByBride(person)).thenReturn(marriageCertificates);
        gatherMarriageCertificateTimeLineData.gather(person);
        verifyNoInteractions(gatherMarriageCertificateBrideTimeLineDataMock);
    }

    @Test
    void gatherMarriageCertificateBrideIsCalledTest() {
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setBride(GetRandomPerson());
        marriageCertificates.add(marriageCertificate);
        when(marriageCertificateServiceMock.findAllByBride(person)).thenReturn(marriageCertificates);
        gatherMarriageCertificateTimeLineData.gather(person);
        verify(gatherMarriageCertificateBrideTimeLineDataMock).gather(marriageCertificates);
    }

    @Test
    void gatherMarriageCertificateGroomIsCalledTest() {
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setGroom(GetRandomPerson());
        marriageCertificates.add(marriageCertificate);
        when(marriageCertificateServiceMock.findAllByGroom(person)).thenReturn(marriageCertificates);
        gatherMarriageCertificateTimeLineData.gather(person);
        verify(gatherMarriageCertificateGroomTimeLineDataMock).gather(marriageCertificates);
    }


}