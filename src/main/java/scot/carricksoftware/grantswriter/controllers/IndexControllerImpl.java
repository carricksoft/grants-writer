/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:08. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import scot.carricksoftware.grantswriter.constants.MappingConstants;
import scot.carricksoftware.grantswriter.constants.ViewConstants;

@Controller
public class IndexControllerImpl implements IndexController {

    private static final Logger logger = LogManager.getLogger(IndexControllerImpl.class);


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CREATE_TEX)
    @Override
    public final String createTex(final Model model) {
        logger.debug("IndexControllerImpl::createTex");
        return ViewConstants.NOT_AVAILABLE;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BUILD_PDF)
    @Override
    public String buildPDF(final Model model) {
        logger.debug("IndexControllerImpl::buildPDF");
        return ViewConstants.NOT_AVAILABLE;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PRINT)
    @Override
    public String print(final Model model) {
        logger.debug("IndexControllerImpl::print");
        return ViewConstants.NOT_AVAILABLE;
    }


}
