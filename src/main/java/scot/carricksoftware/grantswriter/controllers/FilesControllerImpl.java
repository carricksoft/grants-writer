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
public class FilesControllerImpl implements FilesController {

    private static final Logger logger = LogManager.getLogger(FilesControllerImpl.class);

    private final WriterFiles writerFiles;

    public FilesControllerImpl(WriterFiles writerFiles) {
        this.writerFiles = writerFiles;
    }

    @GetMapping(MappingConstants.FILES)
    @Override
    public String getFiles(Model model) {
        logger.debug("FilesControllerImpl::getSelectionPage");
        if (isNull(writerFiles.getLatexFileName())) {
            writerFiles.init();
        }
        model.addAttribute(AttributeConstants.WRITER_FILES, writerFiles);
        return ViewConstants.FILES;
    }
}
