/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.certificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;


@Component
public class DeathCertificateCommandValidator {
    private static final Logger logger = LogManager.getLogger(DeathCertificateCommandValidator.class);

    public void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating death certificate command");
        if (deathCertificateCommand.getDeceased() == null) {
            bindingResult.rejectValue("deceased", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.PERSON_IS_NULL);
        }
    }


}

