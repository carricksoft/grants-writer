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
class DataLoaderTest {

    private DataLoader dataLoader;

    @Mock
    private DataLoaderPrimary dataLoaderPrimaryMock;

    @Mock
    private DataLoaderSecondary dataLoaderSecondaryMock;


    @BeforeEach
    void setUp() {
        dataLoader = new DataLoader(dataLoaderPrimaryMock,
                dataLoaderSecondaryMock);
    }

    @Test
    void dataLoaderPrimaryIsCalledTest() {
        dataLoader.run();
        verify(dataLoaderPrimaryMock).load();
    }

    @Test
    void dataLoaderSecondaryIsCalledTest() {
        dataLoader.run();
        verify(dataLoaderSecondaryMock).load();
    }



}