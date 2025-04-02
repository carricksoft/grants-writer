/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.images.image.ImageService;

import static java.lang.Integer.max;

@Controller
public class ImageListControllerImpl implements ImageListController {

    private static final Logger logger = LogManager.getLogger(ImageListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final ImageService imageService;

    public ImageListControllerImpl(ControllerHelper controllerHelper,
                                   ImageService imageService) {
        this.controllerHelper = controllerHelper;
        this.imageService = imageService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.IMAGE_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getImagePage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(ImageAttributeConstants.IMAGES, imageService.getPagedImages(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.IMAGE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.IMAGE_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("ImageListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.IMAGE_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("ImageListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.IMAGE_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("ImageListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.IMAGE_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("ImageListControllerImpl::getLastPage");
        long imageCount = imageService.count();
        currentPage = (int) (imageCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.IMAGE_DELETE)
    @Override
    public final String imageDelete(@PathVariable final String id) {
        logger.debug("ImageListControllerImpl::imageDelete");
        imageService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + MappingConstants.COUNTRIES;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
