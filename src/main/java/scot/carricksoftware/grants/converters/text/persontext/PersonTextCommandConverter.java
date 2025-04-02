/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:11. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.persontext;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.domains.text.PersonText;

@Component
public interface PersonTextCommandConverter extends Converter<PersonTextCommand, PersonText> {

    @Override
    PersonText convert(@SuppressWarnings("NullableProblems") @NotNull PersonTextCommand source);


}
