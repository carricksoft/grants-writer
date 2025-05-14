/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:08. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.controllers;


import org.springframework.ui.Model;


public interface FilesController {

    @SuppressWarnings("SameReturnValue")
    String getFiles(Model model);
}
