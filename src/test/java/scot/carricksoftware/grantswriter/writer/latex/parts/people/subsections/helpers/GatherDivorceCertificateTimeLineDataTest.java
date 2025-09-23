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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.GatherDivorceCertificateFirstPartyTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate.GatherDivorceCertificateSecondPartyTimeLineData;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherDivorceCertificateTimeLineDataTest {

    private GatherDivorceCertificateTimeLineData gatherDivorceCertificateTimeLineData;

    @Mock private DivorceCertificateService divorceCertificateServiceMock;
    @Mock private GatherDivorceCertificateFirstPartyTimeLineData gatherDivorceCertificateFirstPartyTimeLineDataMock;
    @Mock private GatherDivorceCertificateSecondPartyTimeLineData gatherDivorceCertificateSecondPartyTimeLineDataMock;

    List<DivorceCertificate> divorceCertificates;
    Person person;

    @BeforeEach
    void setUp() {
        gatherDivorceCertificateTimeLineData = new GatherDivorceCertificateTimeLineDataImpl(
                divorceCertificateServiceMock,
                gatherDivorceCertificateFirstPartyTimeLineDataMock,
                gatherDivorceCertificateSecondPartyTimeLineDataMock);
        divorceCertificates = new ArrayList<>();

        person = GetRandomPerson();
    }


    @Test
    void nullFirstPartyTest() {
        when(divorceCertificateServiceMock.findAllByFirstParty(person)).thenReturn(divorceCertificates);
        gatherDivorceCertificateTimeLineData.gather(person);
        verifyNoInteractions(gatherDivorceCertificateFirstPartyTimeLineDataMock);
    }

    @Test
    void nullSecondPartyTest() {
        when(divorceCertificateServiceMock.findAllBySecondParty(person)).thenReturn(divorceCertificates);
        gatherDivorceCertificateTimeLineData.gather(person);
        verifyNoInteractions(gatherDivorceCertificateSecondPartyTimeLineDataMock);
    }

    @Test
    void gatherDivorceCertificateFirstPartyIsCalledTest() {
        divorceCertificates.add(new DivorceCertificate());
        when(divorceCertificateServiceMock.findAllByFirstParty(person)).thenReturn(divorceCertificates);
        gatherDivorceCertificateTimeLineData.gather(person);
        verify(gatherDivorceCertificateFirstPartyTimeLineDataMock).gather(divorceCertificates);
    }

    @Test
    void gatherDivorceCertificateSecondPartyIsCalledTest() {
        divorceCertificates.add(new DivorceCertificate());
        when(divorceCertificateServiceMock.findAllBySecondParty(person)).thenReturn(divorceCertificates);
        gatherDivorceCertificateTimeLineData.gather(person);
        verify(gatherDivorceCertificateSecondPartyTimeLineDataMock).gather(divorceCertificates);
    }

}