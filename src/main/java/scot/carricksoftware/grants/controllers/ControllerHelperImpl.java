/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ButtonConstants;

@SuppressWarnings("unused")
@Component
public class ControllerHelperImpl implements ControllerHelper {

    @SuppressWarnings("unused")
    public void addAttributes(Model model) {
        model.addAttribute("BUTTON_BACK", ButtonConstants.BACK);
        model.addAttribute("BUTTON_DELETE", ButtonConstants.DELETE);
        model.addAttribute("BUTTON_EDIT", ButtonConstants.EDIT);
        model.addAttribute("BUTTON_NEW", ButtonConstants.NEW);
        model.addAttribute("BUTTON_HOME", ButtonConstants.HOME);
        model.addAttribute("BUTTON_REWIND", ButtonConstants.REWIND);
        model.addAttribute("BUTTON_END", ButtonConstants.END);
        model.addAttribute("BUTTON_FORWARD", ButtonConstants.FORWARD);
    }
}
