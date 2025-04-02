/*
 * Copyright (c) Andrew Grant of Carrick Software 12/03/2025, 17:46. All rights reserved.
 *
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DataLoaderSecondaryTest {

    private DataLoaderSecondary dataLoaderSecondary;

    @Mock
    private DataLoadCertificates dataLoadCertificatesMock;

    @Mock
    private DataLoadTwoPartyCertificates dataLoadTwoPartyCertificatesMock;

    @Mock
    private DataLoadImages dataLoadImagesMock;

    @Mock
    private DataLoadTexts dataLoadTextsMock;


    @BeforeEach
    void setUp() {
        dataLoaderSecondary = new DataLoaderSecondary(dataLoadCertificatesMock,
                dataLoadTwoPartyCertificatesMock,
                dataLoadTextsMock,
                dataLoadImagesMock);
    }


    @Test
    void loadCertificatesIsCalledTest() {
        dataLoaderSecondary.load();
        verify(dataLoadCertificatesMock).load();
    }

    @Test
    void loadCertificatesTwoPartyIsCalledTest() {
        dataLoaderSecondary.load();
        verify(dataLoadTwoPartyCertificatesMock).load();
    }

    @Test
    void loadCertificatesTextsIsCalledTest() {
        dataLoaderSecondary.load();
        verify(dataLoadTextsMock).load();
    }

    @Test
    void loadCertificatesImagesIsCalledTest() {
        dataLoaderSecondary.load();
        verify(dataLoadImagesMock).load();
    }

}