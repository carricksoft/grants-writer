/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;

@SuppressWarnings("unused")

public interface RegionFormController {

    String saveOrUpdate(@ModelAttribute RegionCommand regionCommand, BindingResult bindingResult, Model model);
}
