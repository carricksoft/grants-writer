/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import scot.carricksoftware.grantswriter.constants.MappingConstants;

public interface TexController {

    @SuppressWarnings("SameReturnValue")
    String screen(Model model);

    @SuppressWarnings("SameReturnValue")
    @PostMapping(MappingConstants.TEX)
    String start() throws Exception;
}
