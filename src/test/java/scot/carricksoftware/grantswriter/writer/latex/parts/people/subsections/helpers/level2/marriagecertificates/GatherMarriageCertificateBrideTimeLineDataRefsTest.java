/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.converters.StringToDMYConverter;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.DMYImpl;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateBrideTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.marriagecertificate.GatherMarriageCertificateBrideTimeLineDataImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherMarriageCertificateBrideTimeLineDataRefsTest {

    GatherMarriageCertificateBrideTimeLineData gatherMarriageCertificateBrideTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    @Mock
    private StringToDMYConverter stringToDMYConverterMock;

    private List<MarriageCertificate> marriageCertificates;

    private Person bride;
    private Person groom;

    @BeforeEach
    void setUp() {
        gatherMarriageCertificateBrideTimeLineData = new GatherMarriageCertificateBrideTimeLineDataImpl(
                timelineDataMock,
                stringToDMYConverterMock);
        marriageCertificates = new ArrayList<>();
        bride = GetRandomPerson();
        groom = GetRandomPerson();
        DMY dmy = new DMYImpl();
        dmy.parse("25/01/1953");
        when(stringToDMYConverterMock.convert(anyString())).thenReturn(dmy);
    }

    @Test
    void refsAreAddedTest() {
        SortedSet<String> refs = new TreeSet<>();
        refs.add(GetRandomString());
        when(timelineDataMock.getRefs()).thenReturn(refs);
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setBride(bride);
        marriageCertificate.setGroom(groom);
        marriageCertificate.setBrideRank("RandomQ");
        marriageCertificate.setWhenMarried("25/01/1953");
        marriageCertificates.add(marriageCertificate);

        gatherMarriageCertificateBrideTimeLineData.gather(marriageCertificates);
        assertTrue(refs.contains("Marriage Certificate for : " + bride.toString() + " and " + groom.toString()));
    }
}