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


class DeathCertificateMilitaryTest {

    private DeathCertificate deathCertificate;

    @BeforeEach
    void setUp() {
        deathCertificate = new DeathCertificate();
    }

    @Test
    void getRegimentTest() {
        assertNull(deathCertificate.getRegiment());
    }

    @Test
    void setRegimentTest() {
        String regiment = GetRandomString();
        deathCertificate.setRegiment(regiment);
        assertEquals(regiment, deathCertificate.getRegiment());
    }

    @Test
    void getServiceNumberTest() {
        assertNull(deathCertificate.getServiceNumber());
    }

    @Test
    void setServiceNumberTest() {
        String serviceNumber = GetRandomString();
        deathCertificate.setServiceNumber(serviceNumber);
        assertEquals(serviceNumber, deathCertificate.getServiceNumber());
    }

    @Test
    void getServiceRankTest() {
        assertNull(deathCertificate.getServiceRank());
    }

    @Test
    void setServiceRankTest() {
        String serviceRank = GetRandomString();
        deathCertificate.setServiceRank(serviceRank);
        assertEquals(serviceRank, deathCertificate.getServiceRank());
    }




}