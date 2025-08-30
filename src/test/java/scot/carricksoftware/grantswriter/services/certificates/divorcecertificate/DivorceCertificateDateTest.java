/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.certificates.divorcecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate.DivorceCertificate;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


class DivorceCertificateDateTest {

    private DivorceCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new DivorceCertificate();
    }

    @Test
    public void getFirstPartyDateTest() {
        assertNull(certificate.getFirstPartyDate());
    }

    @Test
    public void setFirstPartyDateTest() {
        String string = GetRandomString();
        certificate.setFirstPartyDate(string);
        assertEquals(string, certificate.getFirstPartyDate());
    }

    @Test
    public void getSecondPartyDateTest() {
        assertNull(certificate.getSecondPartyDate());
    }

    @Test
    public void setSecondPartyDateTest() {
        String string = GetRandomString();
        certificate.setSecondPartyDate(string);
        assertEquals(string, certificate.getSecondPartyDate());
    }

    @Test
    public void getRegisteredDateTest() {
        assertNull(certificate.getRegisteredDate());
    }

    @Test
    public void setRegisteredDateTest() {
        String string = GetRandomString();
        certificate.setRegisteredDate(string);
        assertEquals(string, certificate.getRegisteredDate());
    }






}