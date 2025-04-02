/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:20. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


class MarriageCertificateTest {

    private MarriageCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new MarriageCertificate();
    }

    @Test
    public void getIdTest() {
        assertNull(certificate.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        certificate.setId(id);
        assertEquals(id, certificate.getId());
    }

    @Test
    public void getBrideTest() {
        assertNull(certificate.getBride());
    }

    @Test
    public void setBrideTest() {
        Person person = GetRandomPerson();
        certificate.setBride(person);
        assertEquals(person, certificate.getBride());
    }

    @Test
    public void getGroomTest() {
        assertNull(certificate.getGroom());
    }

    @Test
    public void setGroomTest() {
        Person person = GetRandomPerson();
        certificate.setGroom(person);
        assertEquals(person, certificate.getGroom());
    }


}