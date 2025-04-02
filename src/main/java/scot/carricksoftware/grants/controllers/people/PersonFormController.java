/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.people.PersonCommand;

@SuppressWarnings("unused")

public interface PersonFormController {

    String saveOrUpdate(@ModelAttribute PersonCommand personCommand, BindingResult bindingResult, Model model);
}
