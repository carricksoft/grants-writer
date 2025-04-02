/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:10. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.documenttext;


import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.commands.text.DocumentTextCommandImpl;
import scot.carricksoftware.grants.domains.text.DocumentText;

@Component
public class DocumentTextConverterImpl implements DocumentTextConverter {

    private static final Logger logger = LogManager.getLogger(DocumentTextConverterImpl.class);

    @Override
    public DocumentTextCommand convert(@NotNull DocumentText source) {
        logger.debug("DocumentTextConverter::convert");
        DocumentTextCommand target = new DocumentTextCommandImpl();
        target.setId(source.getId());
        return target;
    }


}
