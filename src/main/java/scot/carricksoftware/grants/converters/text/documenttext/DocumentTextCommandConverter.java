/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:10. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.documenttext;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.domains.text.DocumentText;

@Component
public interface DocumentTextCommandConverter extends Converter<DocumentTextCommand, DocumentText> {

    @Override
    DocumentText convert(@SuppressWarnings("NullableProblems") @NotNull DocumentTextCommand source);


}
