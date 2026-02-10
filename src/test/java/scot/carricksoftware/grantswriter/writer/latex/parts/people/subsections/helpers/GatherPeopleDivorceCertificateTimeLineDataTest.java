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
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.certificates.divorcecertificate.DivorceCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.GatherPeopleDivorceCertificateFirstPartyTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.GatherPeopleDivorceCertificateSecondPartyTimeLineData;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherPeopleDivorceCertificateTimeLineDataTest {

    private GatherPeopleDivorceCertificateTimeLineData gatherPeopleDivorceCertificateTimeLineData;

    @Mock
    private DivorceCertificateService divorceCertificateServiceMock;
    @Mock
    private GatherPeopleDivorceCertificateFirstPartyTimeLineData gatherPeopleDivorceCertificateFirstPartyTimeLineDataMock;
    @Mock
    private GatherPeopleDivorceCertificateSecondPartyTimeLineData gatherPeopleDivorceCertificateSecondPartyTimeLineDataMock;

    List<DivorceCertificate> divorceCertificates;
    Person person;

    @BeforeEach
    void setUp() {
        gatherPeopleDivorceCertificateTimeLineData = new GatherPeopleDivorceCertificateTimeLineDataImpl(
                divorceCertificateServiceMock,
                gatherPeopleDivorceCertificateFirstPartyTimeLineDataMock,
                gatherPeopleDivorceCertificateSecondPartyTimeLineDataMock);
        divorceCertificates = new ArrayList<>();

        person = GetRandomPerson();
    }


    @Test
    void nullFirstPartyTest() {
        when(divorceCertificateServiceMock.findAllByFirstParty(person)).thenReturn(divorceCertificates);
        gatherPeopleDivorceCertificateTimeLineData.gather(person);
        verifyNoInteractions(gatherPeopleDivorceCertificateFirstPartyTimeLineDataMock);
    }

    @Test
    void nullSecondPartyTest() {
        when(divorceCertificateServiceMock.findAllBySecondParty(person)).thenReturn(divorceCertificates);
        gatherPeopleDivorceCertificateTimeLineData.gather(person);
        verifyNoInteractions(gatherPeopleDivorceCertificateSecondPartyTimeLineDataMock);
    }

    @Test
    void gatherDivorceCertificateFirstPartyIsCalledTest() {
        divorceCertificates.add(new DivorceCertificate());
        when(divorceCertificateServiceMock.findAllByFirstParty(person)).thenReturn(divorceCertificates);
        gatherPeopleDivorceCertificateTimeLineData.gather(person);
        verify(gatherPeopleDivorceCertificateFirstPartyTimeLineDataMock).gather(divorceCertificates);
    }

    @Test
    void gatherDivorceCertificateSecondPartyIsCalledTest() {
        divorceCertificates.add(new DivorceCertificate());
        when(divorceCertificateServiceMock.findAllBySecondParty(person)).thenReturn(divorceCertificates);
        gatherPeopleDivorceCertificateTimeLineData.gather(person);
        verify(gatherPeopleDivorceCertificateSecondPartyTimeLineDataMock).gather(divorceCertificates);
    }

}