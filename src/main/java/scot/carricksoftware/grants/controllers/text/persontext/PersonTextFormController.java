/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.persontext;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;

@SuppressWarnings("unused")

public interface PersonTextFormController {

    String saveOrUpdate(@ModelAttribute PersonTextCommand personTextCommand, BindingResult bindingResult, Model model);
}
