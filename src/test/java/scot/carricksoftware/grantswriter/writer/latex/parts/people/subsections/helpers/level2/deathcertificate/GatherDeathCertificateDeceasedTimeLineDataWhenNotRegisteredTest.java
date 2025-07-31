/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.deathcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.certificates.deathcertificate.DeathCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Organisation;
import scot.carricksoftware.grantswriter.domains.places.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class GatherDeathCertificateDeceasedTimeLineDataWhenNotRegisteredTest {

    GatherDeathCertificateDeceasedTimeLineData gatherDeathCertificateDeceasedTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    private List<DeathCertificate> deathCertificates;

    private TreeMap<DMY, List<String>> timeLine ;

    private Place place;

    private Person deceased;

    private Organisation registrationAuthority;

    private Person informant;


    @BeforeEach
    void setUp() {
        gatherDeathCertificateDeceasedTimeLineData = new GatherDeathCertificateDeceasedTimeLineDataImpl(this.timelineDataMock);
        deathCertificates = new ArrayList<>();

        DeathCertificate deathCertificate = new DeathCertificate();
        timeLine = new TreeMap<>();
        place = GetRandomPlace();
        registrationAuthority = new Organisation();
        registrationAuthority.setName(place.getName());
        deceased = GetRandomPerson();
        informant = GetRandomPerson();
        setUpCertificate(deathCertificate);
        deathCertificates.add(deathCertificate);

    }

    private void setUpCertificate(DeathCertificate deathCertificate) {
        deathCertificate.setWhenDied("25/01/1953 01:01");
        deathCertificate.setWhenRegistered("25/01/1953 01:01");
        deathCertificate.setWhereDied(place);
        deathCertificate.setDeceased(deceased);
        deathCertificate.setRegistrationAuthority(registrationAuthority);
        deathCertificate.setInformant(informant);
    }

    @Test
    void registeredByTest() {
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);
        gatherDeathCertificateDeceasedTimeLineData.gather(deathCertificates);
        String expected = "Death registered by " + informant + " at " + registrationAuthority;
        assertTrue(timelineContains(expected));
    }

    private boolean timelineContains(String expected) {
        for (Map.Entry<DMY, List<String>> dmyListEntry : timeLine.entrySet()) {
            List<String> list = dmyListEntry.getValue();
            if (list.contains(expected)) {
                return true;
            }
        }
        return false;
    }


}