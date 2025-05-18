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
import static org.mockito.Mockito.verify;


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
    public void screenReturnsTheCorrectView() {
        assertEquals("tex", controller.screen(modelMock));
    }

}

