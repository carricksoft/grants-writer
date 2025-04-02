/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.certificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;


@Component
public class BirthCertificateCommandValidator {
    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandValidator.class);

    @SuppressWarnings("unused")
    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command");
        if (birthCertificateCommand.getNewBorn() == null) {
            bindingResult.rejectValue("person", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.PERSON_IS_NULL);
        }
    }


}

