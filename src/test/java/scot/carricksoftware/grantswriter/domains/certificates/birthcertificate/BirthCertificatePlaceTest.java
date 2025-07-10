/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.birthcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

class BirthCertificatePlaceTest {

    BirthCertificate birthCertificate;

    @BeforeEach
    void setUp() {
        birthCertificate = new BirthCertificate();
    }

    @Test
    void getIDTest() {
        assertNull(birthCertificate.getId());
    }

    @Test
    void getWhereBornTest() {
        assertNull(birthCertificate.getWhereBorn());
    }

    @Test
    void setWhereBornTest() {
        Place whereBorn = GetRandomPlace();
        birthCertificate.setWhereBorn(whereBorn);
        assertEquals(whereBorn, birthCertificate.getWhereBorn());
    }

    @Test
    void getUntrackedWhereBornTest() {
        assertNull(birthCertificate.getUntrackedWhereBorn());
    }

    @Test
    void setUntrackedWhereBornTest() {
        String whereBorn = GetRandomString();
        birthCertificate.setUntrackedWhereBorn(whereBorn);
        assertEquals(whereBorn, birthCertificate.getUntrackedWhereBorn());
    }

    @Test
    void getWhereRegisteredTest() {
        assertNull(birthCertificate.getWhereRegistered());
    }

    @Test
    void setWhereRegisteredTest() {
        String whereRegistered = GetRandomString();
        birthCertificate.setWhereRegistered(whereRegistered);
        assertEquals(whereRegistered, birthCertificate.getWhereRegistered());
    }

}