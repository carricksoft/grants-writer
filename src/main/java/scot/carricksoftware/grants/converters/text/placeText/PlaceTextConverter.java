/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.placeText;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.domains.text.PlaceText;

@SuppressWarnings("unused")
@Component
public interface PlaceTextConverter extends Converter<PlaceText, PlaceTextCommand> {

    @SuppressWarnings("NullableProblems")
    PlaceTextCommand convert(PlaceText source);
}
