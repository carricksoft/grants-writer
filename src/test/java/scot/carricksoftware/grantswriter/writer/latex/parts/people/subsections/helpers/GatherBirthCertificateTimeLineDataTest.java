/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.services.certificates.birthcertificate.BirthCertificateService;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.level2.GatherBirthCertificateNewBornTimeLineData;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class GatherBirthCertificateTimeLineDataTest {

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private GatherBirthCertificateNewBornTimeLineData gatherBirthCertificateNewBornTimeLineDataMock;

    private GatherBirthCertificateTimeLineData gatherBirthCertificateTimeLineData;

    @BeforeEach
    void setUp() {
        gatherBirthCertificateTimeLineData = new GatherBirthCertificateTimeLineDataImpl(birthCertificateServiceMock, gatherBirthCertificateNewBornTimeLineDataMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(gatherBirthCertificateTimeLineData);
    }
}