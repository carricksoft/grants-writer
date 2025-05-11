/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import scot.carricksoftware.grantswriter.constants.MappingConstants;
import scot.carricksoftware.grantswriter.constants.ViewConstants;

@Controller
public class FilesControllerImpl implements FilesController {

    private static final Logger logger = LogManager.getLogger(FilesControllerImpl.class);

   @Override
   @GetMapping(MappingConstants.FILES)
    public String getFiles() {
       logger.debug("FilesControllerImpl::getSelectionPage");
       return ViewConstants.FILES;
    }
}
