/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.places;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;

@SuppressWarnings("unused")

public interface PlaceFormController {

    String saveOrUpdate(@ModelAttribute PlaceCommand placeCommand, BindingResult bindingResult, Model model);
}
