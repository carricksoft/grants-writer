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
import scot.carricksoftware.grantswriter.constants.AttributeConstants;
import scot.carricksoftware.grantswriter.services.status.StatusService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatusControllerTest {

    private StatusController controller;

    @Mock
    private StatusService statusServiceMock;

    @Mock
    private Model modelMock;


    @BeforeEach
    void setUp() {
        controller = new StatusControllerImpl(statusServiceMock);
    }

    @Test
    void getStatusAddAttributeTest() {
        controller.getStatus(modelMock);
        verify(modelMock).addAttribute(AttributeConstants.STATUS_FILE, statusServiceMock.getStatus());
    }

    @Test
    void getStatusReturnTest() {
        assertEquals("statusList", controller.getStatus(modelMock));
    }
}