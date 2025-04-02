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
class DataLoaderPrimaryTest {

    private DataLoaderPrimary dataLoaderPrimary;

    @Mock
    private DataLoadPlaces dataLoadPlacesMock;

    @Mock
    private DataLoadPeople dataLoadPeopleMock;

    @Mock
    private DataLoadCensus dataLoadCensusMock;

    @BeforeEach
    void setUp() {
        dataLoaderPrimary = new DataLoaderPrimary(dataLoadPlacesMock,
                dataLoadPeopleMock,
                dataLoadCensusMock);
    }

    @Test
    void loadCertificatesIsCalledTest() {
        dataLoaderPrimary.load();
        verify(dataLoadPlacesMock).load();
    }

    @Test
    void loadCertificatesTwoPartyIsCalledTest() {
        dataLoaderPrimary.load();
        verify(dataLoadPeopleMock).load();
    }

    @Test
    void loadCertificatesTextsIsCalledTest() {
        dataLoaderPrimary.load();
        verify(dataLoadCensusMock).load();
    }


}