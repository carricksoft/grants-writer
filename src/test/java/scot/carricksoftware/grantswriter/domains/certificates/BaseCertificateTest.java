/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;


class BaseCertificateTest {

    private BaseCertificate baseCertificate;

    @BeforeEach
    void setUp() {
        baseCertificate = new BaseCertificate();
    }

    @Test
    void getCertificateSourceTest(){
        assertNull(baseCertificate.getCertificateSource());
    }

    @Test
    void getCertificateDateTest(){
        assertNull(baseCertificate.getCertificateDate());
    }

    @Test
    void getCertificateTypeTest(){
        assertNull(baseCertificate.getCertificateType());
    }

    @Test
    void getRegistrationAuthorityTest(){
        assertNull(baseCertificate.getRegistrationAuthority());
    }


}