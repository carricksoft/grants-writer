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
import scot.carricksoftware.grantswriter.services.status.StatusService;


@Controller
public class StatusControllerImpl implements StatusController {

    private static final Logger logger = LogManager.getLogger(StatusControllerImpl.class);

    private final StatusService statusService;

    public StatusControllerImpl(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping(MappingConstants.STATUS)
    @Override
    public String getStatus(Model model) {
        logger.info("StatusControllerImp::getStatus");
        model.addAttribute(AttributeConstants.STATUS_FILE,statusService.getStatus());
        return ViewConstants.STATUS;
    }


}
