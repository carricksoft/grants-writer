/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:08. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import scot.carricksoftware.grantswriter.constants.MappingConstants;

public interface StatusController {

    @GetMapping(MappingConstants.FILES)
    String getStatus(Model model);
}
