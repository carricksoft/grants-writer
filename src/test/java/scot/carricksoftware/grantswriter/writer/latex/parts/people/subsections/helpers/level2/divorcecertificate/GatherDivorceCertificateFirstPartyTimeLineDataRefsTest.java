/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.divorcecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.converters.StringToDMYConverter;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomDMYValues.GetRandomDMY;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherDivorceCertificateFirstPartyTimeLineDataRefsTest {

    GatherDivorceCertificateFirstPartyTimeLineData gatherDivorceCertificateFirstPartyTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    @Mock
    private StringToDMYConverter stringToDMYConverterMock;

    private List<DivorceCertificate> divorceCertificates;

    private Person firstParty;
    private Person secondParty;

    @BeforeEach
    void setUp() {
        gatherDivorceCertificateFirstPartyTimeLineData = new GatherDivorceCertificateFirstPartyTimeLineDataImpl(
                timelineDataMock,
                stringToDMYConverterMock);
        divorceCertificates = new ArrayList<>();
        firstParty = GetRandomPerson();
        secondParty = GetRandomPerson();
        DMY dmy = GetRandomDMY();
        when(stringToDMYConverterMock.convert(anyString())).thenReturn(dmy);
    }

    @Test
    void refsAreAddedTest() {
        SortedSet<String> refs = new TreeSet<>();
        refs.add(GetRandomString());
        when(timelineDataMock.getRefs()).thenReturn(refs);
        DivorceCertificate divorceCertificate = new DivorceCertificate();
        divorceCertificate.setFirstParty(firstParty);
        divorceCertificate.setSecondParty(secondParty);
        divorceCertificate.setRegisteredDate("25/01/1953");
        divorceCertificates.add(divorceCertificate);

        gatherDivorceCertificateFirstPartyTimeLineData.gather(divorceCertificates);
        assertTrue(refs.contains("Divorce Certificate for : " + firstParty.toString() + " and " + secondParty.toString()));
    }
}