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
import scot.carricksoftware.grantswriter.domains.people.Person;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GatherPeopleTimeLineDataTest {

    private GatherPeopleTimeLineData gatherPeopleTimeLineData;

    @Mock
    private GatherCensusTimeLineData gatherCensusTimeLineDataMock;
    @Mock
    private GatherPeopleBirthCertificateTimeLineData gatherPeopleBirthCertificateTimeLineDataMock;
    @Mock
    private GatherPeopleDeathCertificateTimeLineData gatherPeopleDeathCertificateTimeLineDataMock;
    @Mock
    private GatherPeopleMarriageCertificateTimeLineData gatherPeopleMarriageCertificateTimeLineDataMock;
    @Mock
    private GatherPeopleDivorceCertificateTimeLineData gatherPeopleDivorceCertificateTimeLineDataMock;
    @Mock
    private Person personMock;

    @BeforeEach
    void setUp() {
        gatherPeopleTimeLineData = new GatherPeopleTimeLineDataImpl(gatherCensusTimeLineDataMock,
                gatherPeopleBirthCertificateTimeLineDataMock,
                gatherPeopleDeathCertificateTimeLineDataMock,
                gatherPeopleMarriageCertificateTimeLineDataMock,
                gatherPeopleDivorceCertificateTimeLineDataMock);
    }

    @Test
    void gatherCensusEntryDataTest() {
        gatherPeopleTimeLineData.gather(personMock);
        verify(gatherCensusTimeLineDataMock).gather(personMock);
    }

    @Test
    void gatherBirthCertificateDataTest() {
        gatherPeopleTimeLineData.gather(personMock);
        verify(gatherPeopleBirthCertificateTimeLineDataMock).gather(personMock);
    }

    @Test
    void gatherDeathCertificateDataTest() {
        gatherPeopleTimeLineData.gather(personMock);
        verify(gatherPeopleDeathCertificateTimeLineDataMock).gather(personMock);
    }

    @Test
    void gatherMarriageCertificateDataTest() {
        gatherPeopleTimeLineData.gather(personMock);
        verify(gatherPeopleMarriageCertificateTimeLineDataMock).gather(personMock);
    }

    @Test
    void gatherDivorceCertificateDataTest() {
        gatherPeopleTimeLineData.gather(personMock);
        verify(gatherPeopleDivorceCertificateTimeLineDataMock).gather(personMock);
    }

}