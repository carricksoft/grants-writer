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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateFirstWitnessTimeLineDataImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateGroomTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateSecondWitnessTimeLineDataImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherMarriageCertificateWitnessTimeLineDataTest {

    private GatherPeopleMarriageCertificateTimeLineData gatherPeopleMarriageCertificateTimeLineData;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;
    @Mock
    private GatherMarriageCertificateBrideTimeLineData gatherMarriageCertificateBrideTimeLineDataMock;
    @Mock
    private GatherMarriageCertificateGroomTimeLineData gatherMarriageCertificateGroomTimeLineDataMock;
    @Mock
    private GatherMarriageCertificateFirstWitnessTimeLineDataImpl gatherMarriageCertificateFirstWitnessTimeLineDataMock;
    @Mock
    private GatherMarriageCertificateSecondWitnessTimeLineDataImpl gatherMarriageCertificateSecondWitnessTimeLineDataMock;

    List<MarriageCertificate> marriageCertificates;
    Person person;

    @BeforeEach
    void setUp() {
        gatherPeopleMarriageCertificateTimeLineData = new GatherPeopleMarriageCertificateTimeLineDataImpl(
                marriageCertificateServiceMock,
                gatherMarriageCertificateBrideTimeLineDataMock,
                gatherMarriageCertificateGroomTimeLineDataMock,
                gatherMarriageCertificateFirstWitnessTimeLineDataMock,
                gatherMarriageCertificateSecondWitnessTimeLineDataMock);
        marriageCertificates = new ArrayList<>();

        person = GetRandomPerson();
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificates.add(marriageCertificate);
    }

    @Test
    void gatherMarriageCertificateFirstWitnessIsCalledTest() {
        when(marriageCertificateServiceMock.findAllByFirstWitness(person)).thenReturn(marriageCertificates);
        gatherPeopleMarriageCertificateTimeLineData.gather(person);
        verify(gatherMarriageCertificateFirstWitnessTimeLineDataMock).gather(marriageCertificates);
    }

    @Test
    void gatherMarriageCertificateSecondWitnessIsCalledTest() {
        when(marriageCertificateServiceMock.findAllBySecondWitness(person)).thenReturn(marriageCertificates);
        gatherPeopleMarriageCertificateTimeLineData.gather(person);
        verify(gatherMarriageCertificateSecondWitnessTimeLineDataMock).gather(marriageCertificates);
    }


}