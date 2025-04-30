/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    private IndexController controller;

    @Mock
    private Model modelMock;

    @BeforeEach
    void setUp() {
        controller = new IndexControllerImpl();
    }

    @Test
    void specifyOutput() {
        assertEquals("not-available",controller.specifyOutput(modelMock));
    }

    @Test
    void createTex() {
        assertEquals("not-available",controller.createTex(modelMock));
    }

    @Test
    void buildPDF() {
        assertEquals("not-available",controller.buildPDF(modelMock));
    }

    @Test
    void print() {
        assertEquals("not-available",controller.print(modelMock));
    }
}