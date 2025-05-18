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
import scot.carricksoftware.grantswriter.writer.TexWriter;

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
    private TexWriter texWriterMock;

    @Mock
    private Model modelMock;

    @BeforeEach
    void setUp() {
        controller = new TexControllerImpl(writerFilesMock, texWriterMock);
    }

    @Test
    public void startReturnsTheCorrectView() throws Exception {
        assertEquals("index", controller.start(modelMock));
    }

    @Test
    public void startReturnsCallsTexWriterWriteTest() throws Exception {
        controller.start(modelMock);
        verify(texWriterMock).write(writerFilesMock.getLatexFileName());
    }

    @Test
    public void screenReturnsTheCorrectViewTest() {
        assertEquals("tex", controller.screen(modelMock));
    }

    @Test
    public void screenSetsTheStatusTest() {
        controller.screen(modelMock);
        verify(writerFilesMock).setStatus("Running");
    }

    @Test
    public void screenInitsTheWriterIfNeededTest() {
        controller.screen(modelMock);
        verify(writerFilesMock).init();
    }

    @Test
    public void screenDoesInitTheWriterIfNotNeededTest() {
        when(writerFilesMock.getLatexFileName()).thenReturn(GetRandomString());
        controller.screen(modelMock);
        verify(writerFilesMock, times(0)).init();
    }

}

