/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grantswriter.files.WriterFiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
class TexControllerTest {

    private TexController controller;

    @Mock
    private WriterFiles writerFilesMock;

    @Mock
    Model modelMock;

    @BeforeEach
    void setUp() {
        controller = new TexControllerImpl(writerFilesMock);
    }

    @Test
    void startReturnsTheCorrectViewTest() {
        assertEquals("tex", controller.start(modelMock));
    }

    @Test
    void startCallsInitIfNeededTest() {
        when(writerFilesMock.getLatexFileName()).thenReturn(null);
        controller.start(modelMock);
        verify(writerFilesMock).init();
    }

    @Test
    void startDoesNotCallInitIfNeededTest() {
        when(writerFilesMock.getLatexFileName()).thenReturn(GetRandomString());
        controller.start(modelMock);
        verify(writerFilesMock, times(0)).init();
    }

}