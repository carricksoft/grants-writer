/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.census;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

import java.time.LocalDate;

@Component
public class CensusCommandValidator {

    public void validate(CensusCommand censusCommand, BindingResult bindingResult) {
        validateDate(censusCommand, bindingResult);
    }

    private void validateDate(CensusCommand censusCommand, BindingResult bindingResult) {
        if (censusCommand.getDate() == null) {
            bindingResult.rejectValue("date", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.DATE_IS_NULL);
        } else if (censusCommand.getDate().isAfter(LocalDate.now())) {
            bindingResult.rejectValue("date", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.DATE_IN_FUTURE);
        }
    }
}

