/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.certificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;


@Component
public class DivorceCertificateCommandValidator {
    private static final Logger logger = LogManager.getLogger(DivorceCertificateCommandValidator.class);

    @SuppressWarnings("unused")
    public void validate(@SuppressWarnings("unused") DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating death certificate command");
        validateTheTwoPartiesInIsolation(divorceCertificateCommand, bindingResult);
        if (!bindingResult.hasErrors()) {
            if (divorceCertificateCommand.getFirstParty() != null &&
                    divorceCertificateCommand.getSecondParty() != null) {
                validateThePartiesTogether(divorceCertificateCommand, bindingResult);
            }
        }
    }

    private void validateThePartiesTogether(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        if (divorceCertificateCommand.getFirstParty().equals(divorceCertificateCommand.getSecondParty())) {
            bindingResult.rejectValue("firstParty", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.SAME_TWO_PARTIES);
            bindingResult.rejectValue("secondParty", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.SAME_TWO_PARTIES);
        }
    }

    private void validateTheTwoPartiesInIsolation(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        if (divorceCertificateCommand.getFirstParty() == null) {
            bindingResult.rejectValue("firstParty", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.FIRST_PARTY_IS_NULL);
        }
        if (divorceCertificateCommand.getSecondParty() == null) {
            bindingResult.rejectValue("secondParty", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.SECOND_PARTY_IS_NULL);
        }

    }


}

