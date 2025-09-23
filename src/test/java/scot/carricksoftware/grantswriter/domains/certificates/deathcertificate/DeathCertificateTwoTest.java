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


class DeathCertificateTwoTest {

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        deathCertificate = new DeathCertificate();
    }

    @Test
    void getCauseOfDeathTest() {
        assertNull(deathCertificate.getCauseOfDeath());
    }

    @Test
    void setCauseOfDeathTest() {
        String causeOfDeath = GetRandomString();
        deathCertificate.setCauseOfDeath(causeOfDeath);
        assertEquals(causeOfDeath, deathCertificate.getCauseOfDeath());
    }

    @Test
    void getInformantQualificationTest() {
        assertNull(deathCertificate.getInformantQualification());
    }

    @Test
    void setInformantQualificationTest() {
        String informantQualification = GetRandomString();
        deathCertificate.setInformantQualification(informantQualification);
        assertEquals(informantQualification, deathCertificate.getInformantQualification());
    }
}