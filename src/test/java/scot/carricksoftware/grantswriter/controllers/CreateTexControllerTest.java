/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
class CreateTexControllerTest {

    private CreateTexController controller;

    @BeforeEach
    void setUp() {
        controller = new CreateTexControllerImpl();
    }

    @Test
    void createExistenceTest() {
        assertNotNull(controller);
    }
}