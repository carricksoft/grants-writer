/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.placetext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.text.placetext.PlaceTextService;

import static java.lang.Integer.max;

@Controller
public class PlaceTextListControllerImpl implements PlaceTextListController {

    private static final Logger logger = LogManager.getLogger(PlaceTextListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final PlaceTextService placeTextService;

    public PlaceTextListControllerImpl(ControllerHelper controllerHelper,
                                       PlaceTextService placeTextService) {
        this.controllerHelper = controllerHelper;
        this.placeTextService = placeTextService;
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PLACE_TEXT_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PlaceTextListControllerImpl::getImagePage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(TextAttributeConstants.PLACE_TEXTS, placeTextService.getPagedPlaceTexts(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.PLACE_TEXT_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PLACE_TEXT_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("PlaceTextListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PLACE_TEXT_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("PlaceTextListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PLACE_TEXT_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("PlaceTextListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PLACE_TEXT_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("PlaceTextListControllerImpl::getLastPage");
        long imageCount = placeTextService.count();
        currentPage = (int) (imageCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PLACE_TEXT_DELETE)
    @Override
    public final String PlaceTextDelete(@PathVariable final String id) {
        logger.debug("PlaceTextListControllerImpl::imageDelete");
        placeTextService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + TextMappingConstants.PLACE_TEXT_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }
    
}
