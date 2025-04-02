/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.persontext;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.domains.text.PersonText;

@SuppressWarnings("unused")
@Component
public interface PersonTextConverter extends Converter<PersonText, PersonTextCommand> {

    @SuppressWarnings("NullableProblems")
    PersonTextCommand convert(PersonText source);
}
