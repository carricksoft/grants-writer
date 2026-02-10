/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.deathcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Organisation;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class GatherPeopleDeathCertificateDeceasedTimeLineDataWhenNowhereRegisteredTest {

    GatherPeopleDeathCertificateDeceasedTimeLineData gatherPeopleDeathCertificateDeceasedTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    private List<DeathCertificate> deathCertificates;

    @Mock
    private TreeMap<DMY, List<String>> timeLineMock;

    private Person deceased;

    private Organisation registrationAuthority;

    private Person informant;

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        gatherPeopleDeathCertificateDeceasedTimeLineData = new GatherPeopleDeathCertificateDeceasedTimeLineDataImpl(this.timelineDataMock);
        deathCertificates = new ArrayList<>();
        deathCertificate = new DeathCertificate();
        String registrationAuthorityName = GetRandomString();
        registrationAuthority = new Organisation();
        registrationAuthority.setName(registrationAuthorityName);
        deceased = GetRandomPerson();
        informant = GetRandomPerson();


    }

    private void setUpCertificate(DeathCertificate deathCertificate) {
        deathCertificate.setWhenDied("25/01/1953 01:01");
        deathCertificate.setWhenRegistered("26/01/1953 01:01");
        deathCertificate.setDeceased(deceased);
        deathCertificate.setRegistrationAuthority(registrationAuthority);
        deathCertificate.setInformant(informant);
    }

    @Test
    void registeredAtNullTest() {
        setUpCertificate(deathCertificate);
        deathCertificates.add(deathCertificate);
        ArgumentCaptor<DMY> dmyCaptor = ArgumentCaptor.forClass(DMY.class);
        //noinspection unchecked
        ArgumentCaptor<List<String>> listCaptor = ArgumentCaptor.forClass(List.class);
        when(timelineDataMock.getTimeLine()).thenReturn(timeLineMock);
        gatherPeopleDeathCertificateDeceasedTimeLineData.gather(deathCertificates);
        verify(timeLineMock, atLeast(1)).put(dmyCaptor.capture(), listCaptor.capture());
        String expected = "Death registered by " + informant + " at " + registrationAuthority;
        for (int i = 0; i < listCaptor.getAllValues().size(); i++) {
            if (expected.equals(listCaptor.getAllValues().get(i).get(0))) {
                assertTrue(true);
                return;
            }
        }
        fail();
    }

    @Test
    void registeredAtEmptyTest() {
        setUpCertificate(deathCertificate);
        deathCertificate.setWhereRegistered("");
        deathCertificates.add(deathCertificate);
        ArgumentCaptor<DMY> dmyCaptor = ArgumentCaptor.forClass(DMY.class);
        //noinspection unchecked
        ArgumentCaptor<List<String>> listCaptor = ArgumentCaptor.forClass(List.class);
        when(timelineDataMock.getTimeLine()).thenReturn(timeLineMock);
        gatherPeopleDeathCertificateDeceasedTimeLineData.gather(deathCertificates);
        verify(timeLineMock, atLeast(1)).put(dmyCaptor.capture(), listCaptor.capture());
        String expected = "Death registered by " + informant + " at " + registrationAuthority;
        for (int i = 0; i < listCaptor.getAllValues().size(); i++) {
            if (expected.equals(listCaptor.getAllValues().get(i).get(0))) {
                assertTrue(true);
                return;
            }
        }
        fail();
    }


}