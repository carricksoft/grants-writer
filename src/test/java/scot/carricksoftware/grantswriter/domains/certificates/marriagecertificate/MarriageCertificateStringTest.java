/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate.MarriageCertificate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


class MarriageCertificateStringTest {

    private MarriageCertificate marriageCertificate;
    private String string;

    @BeforeEach
    void setUp() {
        marriageCertificate = new MarriageCertificate();
        string = GetRandomString();
    }

    @Test
    void getUntrackedWhenMarriedTest() {
        assertNull(marriageCertificate.getWhenMarried());
    }

    @Test
    void setUntrackedWhenMarriedTest() {
        marriageCertificate.setWhenMarried(string);
        assertEquals(string, marriageCertificate.getWhenMarried());
    }

}