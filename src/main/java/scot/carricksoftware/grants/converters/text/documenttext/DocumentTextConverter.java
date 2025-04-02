/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.documenttext;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.domains.text.DocumentText;

@SuppressWarnings("unused")
@Component
public interface DocumentTextConverter extends Converter<DocumentText, DocumentTextCommand> {

    @SuppressWarnings("NullableProblems")
    DocumentTextCommand convert(DocumentText source);
}
