/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.images.ImageCommand;

@SuppressWarnings("unused")

public interface ImageFormController {

    String saveOrUpdate(@ModelAttribute ImageCommand imageCommand, BindingResult bindingResult, Model model);
}
