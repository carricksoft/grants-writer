/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.placetext;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;

@SuppressWarnings("unused")

public interface PlaceTextFormController {

    String saveOrUpdate(@ModelAttribute PlaceTextCommand placeTextCommand, BindingResult bindingResult, Model model);
}
