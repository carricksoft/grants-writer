/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.places.Organisation;
import scot.carricksoftware.grantswriter.enums.certificates.CertificateType;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void setCertificateSourceTest(){
        Organisation organisation = new Organisation();
        baseCertificate.setCertificateSource(organisation);
        assertEquals(organisation,baseCertificate.getCertificateSource());
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
    void setCertificateTypeTest(){
        baseCertificate.setCertificateType(CertificateType.COPY);
        assertEquals(CertificateType.COPY, baseCertificate.getCertificateType());
    }

    @Test
    void getRegistrationAuthorityTest(){
        assertNull(baseCertificate.getRegistrationAuthority());
    }

    @Test
    void setRegistrationAuthorityTest(){
        Organisation organisation = new Organisation();
        baseCertificate.setRegistrationAuthority(organisation);
        assertEquals(organisation,baseCertificate.getRegistrationAuthority());
    }


}