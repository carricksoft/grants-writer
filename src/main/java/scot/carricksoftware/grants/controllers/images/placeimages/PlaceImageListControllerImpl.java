/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.placeimages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.images.placeimage.PlaceImageService;

import static java.lang.Integer.max;

@Controller
public class PlaceImageListControllerImpl implements PlaceImageListController {

    private static final Logger logger = LogManager.getLogger(PlaceImageListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final PlaceImageService placeImageService;

    public PlaceImageListControllerImpl(ControllerHelper controllerHelper,
                                        PlaceImageService placeImageService) {
        this.controllerHelper = controllerHelper;
        this.placeImageService = placeImageService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PLACE_IMAGE_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PlaceListControllerImpl::getPlaceImagePage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(ImageAttributeConstants.PLACE_IMAGES, placeImageService.getPagedPlaceImages(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.PLACE_IMAGE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PLACE_IMAGE_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("PlaceImageListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PLACE_IMAGE_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("PlaceImageListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PLACE_IMAGE_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("PlaceImageListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PLACE_IMAGE_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("PlaceImageListControllerImpl::getLastPage");
        long placeImageCount = placeImageService.count();
        currentPage = (int) (placeImageCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PLACE_IMAGE_DELETE)
    @Override
    public final String placeImageDelete(@PathVariable final String id) {
        logger.debug("PlaceImageListControllerImpl::placeImageDelete");
        placeImageService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + ImageMappingConstants.PLACE_IMAGE_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
