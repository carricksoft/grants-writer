/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.images;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.ImageCommand;

@SuppressWarnings("unused")
@Component
public class ImageCommandValidator {

    private static final Logger logger = LogManager.getLogger(ImageCommandValidator.class);

    public void validate(ImageCommand imageCommand, BindingResult bindingResult) {
      logger.debug("ImageCommandValidator::validate");
    }


}

