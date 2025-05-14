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
    void filesReturnsTheCorrectPageTest() {
        assertEquals("files", controller.getFiles(modelMock));
    }
}