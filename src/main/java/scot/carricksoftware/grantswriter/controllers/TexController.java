/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.controllers;

import org.springframework.ui.Model;

public interface TexController {

    @SuppressWarnings({"SameReturnValue", "unused"})
    String screen(Model model);

    @SuppressWarnings({"SameReturnValue", "unused"})
    String start(Model model) throws Exception;
}
