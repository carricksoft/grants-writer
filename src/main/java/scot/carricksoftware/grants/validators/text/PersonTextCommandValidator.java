/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

@SuppressWarnings("unused")
@Component
public class PersonTextCommandValidator {

    private static final Logger logger = LogManager.getLogger(PersonTextCommandValidator.class);

    public void validate(PersonTextCommand personTextCommand, BindingResult bindingResult) {
      logger.debug("PersonTextCommandValidator::validate");
        if (personTextCommand.getPerson() == null) {
            bindingResult.rejectValue("person", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.PERSON_IS_NULL);
        }


    }


}

