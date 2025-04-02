/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.censusentry;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;

@SuppressWarnings("unused")

public interface CensusEntryFormController {

    String saveOrUpdate(@ModelAttribute CensusEntryCommand censusEntryCommand, BindingResult bindingResult, Model model);
}
