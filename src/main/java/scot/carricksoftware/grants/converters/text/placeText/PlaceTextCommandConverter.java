/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:11. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.placeText;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.domains.text.PlaceText;

@Component
public interface PlaceTextCommandConverter extends Converter<PlaceTextCommand, PlaceText> {

    @Override
    PlaceText convert(@SuppressWarnings("NullableProblems") @NotNull PlaceTextCommand source);


}
