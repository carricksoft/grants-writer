/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import scot.carricksoftware.grantswriter.constants.AttributeConstants;
import scot.carricksoftware.grantswriter.constants.MappingConstants;
import scot.carricksoftware.grantswriter.constants.ViewConstants;
import scot.carricksoftware.grantswriter.files.WriterFiles;

import static java.util.Objects.isNull;

@Controller
public class TexControllerImpl implements TexController {

    private static final Logger logger = LogManager.getLogger(TexControllerImpl.class);

    private final WriterFiles writerFiles;

    public TexControllerImpl(WriterFiles writerFiles) {
        this.writerFiles = writerFiles;
    }

    @GetMapping(MappingConstants.TEX)
    @Override
    public String start(Model model) {
        logger.debug("FilesControllerImpl::getSelectionPage");
        if (isNull(writerFiles.getLatexFileName())) {
            writerFiles.init();
        }
        model.addAttribute(AttributeConstants.WRITER_FILES, writerFiles);
        String status = "status";
        model.addAttribute(AttributeConstants.STATUS, status);
        return ViewConstants.TEX;
    }
}
