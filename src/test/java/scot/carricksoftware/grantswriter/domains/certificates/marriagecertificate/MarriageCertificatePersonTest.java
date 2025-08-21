/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;


class MarriageCertificatePersonTest {

    private MarriageCertificate marriageCertificate;
    private Person person;

    @BeforeEach
    void setUp() {
        marriageCertificate = new MarriageCertificate();
        person = GetRandomPerson();
    }

    @Test
    void getBrideTest() {
        assertNull(marriageCertificate.getBride());
    }

    @Test
    void setBrideTest() {
        marriageCertificate.setBride(person);
        assertEquals(person, marriageCertificate.getBride());
    }

    @Test
    void getGroomTest() {
        assertNull(marriageCertificate.getGroom());
    }

    @Test
    void setGroomTest() {
        marriageCertificate.setGroom(person);
        assertEquals(person, marriageCertificate.getGroom());
    }


    @Test
    void getFirstWitnessTest() {
        assertNull(marriageCertificate.getFirstWitness());
    }

    @Test
    void setFirstWitnessTest() {
        marriageCertificate.setFirstWitness(person);
        assertEquals(person, marriageCertificate.getFirstWitness());
    }

    @Test
    void getSecondWitnessTest() {
        assertNull(marriageCertificate.getSecondWitness());
    }

    @Test
    void setSecondWitnessTest() {
        marriageCertificate.setSecondWitness(person);
        assertEquals(person, marriageCertificate.getSecondWitness());
    }


}