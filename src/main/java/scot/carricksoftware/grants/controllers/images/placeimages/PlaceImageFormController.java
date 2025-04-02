/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.placeimages;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;

@SuppressWarnings("unused")

public interface PlaceImageFormController {

    String saveOrUpdate(@ModelAttribute PlaceImageCommand placeImageCommand, BindingResult bindingResult, Model model);
}
