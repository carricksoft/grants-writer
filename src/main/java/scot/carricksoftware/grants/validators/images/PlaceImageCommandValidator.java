/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.images;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

@SuppressWarnings("unused")
@Component
public class PlaceImageCommandValidator {

    private static final Logger logger = LogManager.getLogger(PlaceImageCommandValidator.class);

    public void validate(PlaceImageCommand imageCommand, BindingResult bindingResult) {
      logger.debug("PlaceImageCommandValidator::validate");
        if (imageCommand.getPlace() == null) {
            bindingResult.rejectValue("place", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.PLACE_IS_NULL);
        }
    }


}

