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
import org.springframework.web.bind.annotation.PostMapping;
import scot.carricksoftware.grantswriter.constants.AttributeConstants;
import scot.carricksoftware.grantswriter.constants.MappingConstants;
import scot.carricksoftware.grantswriter.constants.ViewConstants;
import scot.carricksoftware.grantswriter.files.WriterFiles;
import scot.carricksoftware.grantswriter.writer.TexWriter;

import static java.util.Objects.isNull;

@Controller
public class TexControllerImpl implements TexController {

    private static final Logger logger = LogManager.getLogger(TexControllerImpl.class);

    private final WriterFiles writerFiles;

    private final TexWriter texWriter;

    public TexControllerImpl(WriterFiles writerFiles, TexWriter texWriter) {
        this.writerFiles = writerFiles;
        this.texWriter = texWriter;
    }

    @GetMapping(MappingConstants.TEX)
    @Override
    public String screen(Model model) {
        logger.debug("FilesControllerImpl::screen");
        if (isNull(writerFiles.getLatexFileName())) {
            writerFiles.init();
        }
        model.addAttribute(AttributeConstants.WRITER_FILES, writerFiles);
        writerFiles.setStatus("Running");

        return ViewConstants.TEX;
    }

    @PostMapping(MappingConstants.TEX)
    @Override
    public String start(Model model) throws Exception {
        logger.debug("FilesControllerImpl::start");
        texWriter.write(writerFiles.getLatexFileName());

        return ViewConstants.HOME;
    }
}
