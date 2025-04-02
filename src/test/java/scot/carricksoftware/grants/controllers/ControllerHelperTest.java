/*
 * Copyright (c) Andrew Grant of Carrick Software 13/03/2025, 18:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ButtonConstants;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ControllerHelperTest {

    private ControllerHelper controllerHelper;

    @Mock
    private Model modelMock;

    @BeforeEach
    void setUp() {
        controllerHelper = new ControllerHelperImpl();
    }

    @Test
    public void addAttributesTest() {
        controllerHelper.addAttributes(modelMock);
        verify(modelMock).addAttribute("BUTTON_BACK", ButtonConstants.BACK);
        verify(modelMock).addAttribute("BUTTON_DELETE", ButtonConstants.DELETE);
        verify(modelMock).addAttribute("BUTTON_EDIT", ButtonConstants.EDIT);
        verify(modelMock).addAttribute("BUTTON_NEW", ButtonConstants.NEW);
        verify(modelMock).addAttribute("BUTTON_HOME", ButtonConstants.HOME);
        verify(modelMock).addAttribute("BUTTON_REWIND", ButtonConstants.REWIND);
        verify(modelMock).addAttribute("BUTTON_END", ButtonConstants.END);
        verify(modelMock).addAttribute("BUTTON_FORWARD", ButtonConstants.FORWARD);
    }


}