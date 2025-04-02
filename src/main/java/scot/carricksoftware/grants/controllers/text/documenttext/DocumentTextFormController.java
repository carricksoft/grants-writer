/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.documenttext;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;

@SuppressWarnings("unused")

public interface DocumentTextFormController {

    String saveOrUpdate(@ModelAttribute DocumentTextCommand documentTextCommand, BindingResult bindingResult, Model model);
}
