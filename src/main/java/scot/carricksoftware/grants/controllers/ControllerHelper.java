/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;


@SuppressWarnings("unused")
@Component
public interface ControllerHelper {

    void addAttributes(Model model);
}
