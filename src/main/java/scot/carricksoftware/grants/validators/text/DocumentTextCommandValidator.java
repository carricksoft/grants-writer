/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;

@SuppressWarnings("unused")
@Component
public class DocumentTextCommandValidator {

    private static final Logger logger = LogManager.getLogger(DocumentTextCommandValidator.class);

    public void validate(DocumentTextCommand documentTextCommand, BindingResult bindingResult) {
      logger.debug("DocumentTextCommandValidator::validate");

    }


}

