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
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class FilesControllerTest {

    private FilesController controller;

    @Mock
    private WriterFiles writerFilesMock;

    @Mock
    private Model modelMock;

    @BeforeEach
    void setUp() {
        controller = new FilesControllerImpl(writerFilesMock);
    }

    @Test
    void getFilesReturnsTheCorrectPageTest() {
        assertEquals("files", controller.getFiles(modelMock));
    }

    @Test
    void getFilesCallsInitIfNullTest() {
        when(writerFilesMock.getLatexFileName()).thenReturn(null);
        controller.getFiles(modelMock);
        verify(writerFilesMock).init();
    }

    @Test
    void getFilesDoesNotCallInitIfNotNullTest() {
        when(writerFilesMock.getLatexFileName()).thenReturn(GetRandomString());
        controller.getFiles(modelMock);
        verify(writerFilesMock, times(0)).init();
    }

    @Test
    void gotFilesReturnsTheCorrectPageTest() {
        assertEquals("index", controller.gotFiles(modelMock));
    }

    @Test
    void gotFilesSetsTheWriterFilesAttribute() {
        controller.gotFiles(modelMock);
        verify(modelMock).addAttribute("writerFiles", writerFilesMock);
    }
}