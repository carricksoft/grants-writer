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
import scot.carricksoftware.grantswriter.files.WriterFiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
class TexControllerTest {

    private TexController controller;

    @Mock
    private WriterFiles writerFilesMock;

    @BeforeEach
    void setUp() {
        controller = new TexControllerImpl(writerFilesMock);
    }

    @Test
    void createExistenceTest() {
        assertNotNull(controller);
    }
}