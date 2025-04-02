/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.personImages;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;

@SuppressWarnings("unused")

public interface PersonImageFormController {

    String saveOrUpdate(@ModelAttribute PersonImageCommand personImageCommand, BindingResult bindingResult, Model model);
}
