/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.deathcertificate;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;


class DeathCertificatePersonTest {

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        deathCertificate = new DeathCertificate();
    }

    @Test
    void getDeceasedTest() {
        assertNull(deathCertificate.getDeceased());
    }

    @Test
    void setDeceasedTest() {
        Person deceased = GetRandomPerson();
        deathCertificate.setDeceased(deceased);
        assertEquals(deceased, deathCertificate.getDeceased());
    }

    @Test
    void getFatherTest() {
        assertNull(deathCertificate.getFather());
    }

    @Test
    void setFatherTest() {
        Person father = GetRandomPerson();
        deathCertificate.setFather(father);
        assertEquals(father, deathCertificate.getFather());
    }

    @Test
    void getMotherTest() {
        assertNull(deathCertificate.getMother());
    }

    @Test
    void setMotherTest() {
        Person mother = GetRandomPerson();
        deathCertificate.setMother(mother);
        assertEquals(mother, deathCertificate.getMother());
    }

    @Test
    void getInformantTest() {
        assertNull(deathCertificate.getInformant());
    }

    @Test
    void setInformantTest() {
        Person informant = GetRandomPerson();
        deathCertificate.setInformant(informant);
        assertEquals(informant, deathCertificate.getInformant());
    }

    @Test
    void getSpouseTest() {
        assertNull(deathCertificate.getSpouse());
    }

    @Test
    void setSpouseTest() {
        Person spouse = GetRandomPerson();
        deathCertificate.setSpouse(spouse);
        assertEquals(spouse, deathCertificate.getSpouse());
    }


}