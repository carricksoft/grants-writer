/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 22:25. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.places.places;

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
import scot.carricksoftware.grants.services.places.places.PlaceService;

import static java.lang.Integer.max;

@Controller
public class PLaceListControllerImpl implements PlaceListController {

    private static final Logger logger = LogManager.getLogger(PLaceListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final PlaceService placeService;

    public PLaceListControllerImpl(ControllerHelper controllerHelper,
                                   PlaceService placeService) {
        this.controllerHelper = controllerHelper;
        this.placeService = placeService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PLACE_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getPlacePage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.PLACES, placeService.getPagedPlaces(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.PLACE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PLACE_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("placeListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PLACE_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("placeListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PLACE_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("placeListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PLACE_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("placeListControllerImpl::getLastPage");
        long placeCount = placeService.count();
        currentPage = (int) (placeCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PLACE_DELETE)
    @Override
    public final String placeDelete(@PathVariable final String id) {
        logger.debug("placeListControllerImpl::placeDelete");
        placeService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + MappingConstants.COUNTRIES;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
