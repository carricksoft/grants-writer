/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.images;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

@SuppressWarnings("unused")
@Component
public class PersonImageCommandValidator {

    private static final Logger logger = LogManager.getLogger(PersonImageCommandValidator.class);

    public void validate(PersonImageCommand imageCommand, BindingResult bindingResult) {
      logger.debug("PersonImageCommandValidator::validate");
        if (imageCommand.getPerson() == null) {
            bindingResult.rejectValue("person", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.PERSON_IS_NULL);
        }
    }


}

