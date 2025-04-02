/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 22:25. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.places.regions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.places.regions.RegionService;

import static java.lang.Integer.max;

@Controller
public class RegionListControllerImpl implements RegionListController {

    private static final Logger logger = LogManager.getLogger(RegionListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final RegionService regionService;

    public RegionListControllerImpl(ControllerHelper controllerHelper,
                                    RegionService regionService) {
        this.controllerHelper = controllerHelper;
        this.regionService = regionService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getRegionPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.REGIONS, regionService.getPagedRegions(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.REGION_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("RegionListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("RegionListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("RegionListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("RegionListControllerImpl::getLastPage");
        long regionCount = regionService.count();
        currentPage = (int) (regionCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_DELETE)
    @Override
    public final String regionDelete(@PathVariable final String id) {
        logger.debug("RegionListControllerImpl::regionDelete");
        regionService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + MappingConstants.REGIONS;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
