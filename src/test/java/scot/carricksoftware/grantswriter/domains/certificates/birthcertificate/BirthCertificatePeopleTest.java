/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.birthcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.people.Person;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

class BirthCertificatePeopleTest {

    BirthCertificate birthCertificate;

    @BeforeEach
    void setUp() {
        birthCertificate = new BirthCertificate();
    }

    @Test
    void getNewBornTest() {
        assertNull(birthCertificate.getNewBorn());
    }

    @Test
    void setNewBornTest() {
        Person person = GetRandomPerson();
        birthCertificate.setNewBorn(person);
        assertEquals(person, birthCertificate.getNewBorn());
    }

    @Test
    void getFatherTest() {
        assertNull(birthCertificate.getFather());
    }

    @Test
    void setFatherTest() {
        Person person = GetRandomPerson();
        birthCertificate.setFather(person);
        assertEquals(person, birthCertificate.getFather());
    }

    @Test
    void getMotherTest() {
        assertNull(birthCertificate.getMother());
    }

    @Test
    void setMotherTest() {
        Person person = GetRandomPerson();
        birthCertificate.setMother(person);
        assertEquals(person, birthCertificate.getMother());
    }

    @Test
    void getInformantTest() {
        assertNull(birthCertificate.getInformant());
    }

    @Test
    void setInformantTest() {
        Person person = GetRandomPerson();
        birthCertificate.setInformant(person);
        assertEquals(person, birthCertificate.getInformant());
    }

    @Test
    void getUntrackedInformantTest() {
        assertNull(birthCertificate.getUntrackedInformant());
    }

    @Test
    void setWhenUntrackedInformantTest() {
        String untrackedInformant = GetRandomString();
        birthCertificate.setUntrackedInformant(untrackedInformant);
        assertEquals(untrackedInformant, birthCertificate.getUntrackedInformant());
    }

    @Test
    void getFatherRankTest() {
        assertNull(birthCertificate.getFatherRank());
    }

    @Test
    void setFatherRankTest() {
        String fatherRank = GetRandomString();
        birthCertificate.setFatherRank(fatherRank);
        assertEquals(fatherRank, birthCertificate.getFatherRank());
    }

}