/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.birthcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

class BirthCertificateDateTest {

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
    void setIDTest() {
        Long id = GetRandomLong();
        birthCertificate.setId(id);
        assertEquals(id, birthCertificate.getId());
    }

    @Test
    void getWhenBornTest() {
        assertNull(birthCertificate.getWhenBorn());
    }

    @Test
    void setWhenBornTest() {
        String whenBorn = GetRandomString();
        birthCertificate.setWhenBorn(whenBorn);
        assertEquals(whenBorn, birthCertificate.getWhenBorn());
    }

}