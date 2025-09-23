/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

class BaseCertificateStringTest {

    private BaseCertificate baseCertificate;

    private String testString;

    @BeforeEach
    void setUp() {
        baseCertificate = new BaseCertificate();
        testString = GetRandomString();
    }

    @Test
    void getCertificateNumberTest() {
        assertNull(baseCertificate.getCertificateNumber());
    }

    @Test
    void setCertificateNumberTest() {
        baseCertificate.setCertificateNumber(testString);
        assertEquals(testString, baseCertificate.getCertificateNumber());
    }

    @Test
    void getCertificateDateTest() {
        assertNull(baseCertificate.getCertificateDate());
    }

    @Test
    void setCertificateDateTest() {
        baseCertificate.setCertificateDate(testString);
        assertEquals(testString, baseCertificate.getCertificateDate());
    }

    @Test
    void getVolumeTest() {
        assertNull(baseCertificate.getVolume());
    }

    @Test
    void setVolumeTest() {
        baseCertificate.setVolume(testString);
        assertEquals(testString, baseCertificate.getVolume());
    }

    @Test
    void getNumberTest() {
        assertNull(baseCertificate.getNumber());
    }

    @Test
    void setNumberTest() {
        baseCertificate.setNumber(testString);
        assertEquals(testString, baseCertificate.getNumber());
    }

}