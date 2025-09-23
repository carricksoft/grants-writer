/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.deathcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


class DeathCertificateTimeTest {

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        deathCertificate = new DeathCertificate();
    }

    @Test
    void getWhenBornTest() {
        assertNull(deathCertificate.getWhenBorn());
    }

    @Test
    void setWhenBornTest() {
        String whenBorn = GetRandomString();
        deathCertificate.setWhenBorn(whenBorn);
        assertEquals(whenBorn, deathCertificate.getWhenBorn());
    }

    @Test
    void getAgeTest() {
        assertNull(deathCertificate.getAge());
    }

    @Test
    void setAgeTest() {
        String age = GetRandomString();
        deathCertificate.setAge(age);
        assertEquals(age, deathCertificate.getAge());
    }

    @Test
    void getWhenDiedTest() {
        assertNull(deathCertificate.getWhenDied());
    }

    @Test
    void setWhenDiedTest() {
        String whenDied = GetRandomString();
        deathCertificate.setWhenDied(whenDied);
        assertEquals(whenDied, deathCertificate.getWhenDied());
    }

    @Test
    void getWhenRegisteredTest() {
        assertNull(deathCertificate.getWhenRegistered());
    }

    @Test
    void setWhenRegisteredTest() {
        String whenRegistered = GetRandomString();
        deathCertificate.setWhenRegistered(whenRegistered);
        assertEquals(whenRegistered, deathCertificate.getWhenRegistered());
    }
}