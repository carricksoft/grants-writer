/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.personImages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.images.personimage.PersonImageService;

import static java.lang.Integer.max;

@Controller
public class PersonImageListControllerImpl implements PersonImageListController {

    private static final Logger logger = LogManager.getLogger(PersonImageListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final PersonImageService personImageService;

    public PersonImageListControllerImpl(ControllerHelper controllerHelper,
                                         PersonImageService personImageService) {
        this.controllerHelper = controllerHelper;
        this.personImageService = personImageService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PERSON_IMAGE_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getPersonImagePage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(ImageAttributeConstants.PERSON_IMAGES, personImageService.getPagedPersonImages(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.PERSON_IMAGE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PERSON_IMAGE_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("PersonImageListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PERSON_IMAGE_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("PersonImageListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PERSON_IMAGE_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("PersonImageListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PERSON_IMAGE_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("PersonImageListControllerImpl::getLastPage");
        long personImageCount = personImageService.count();
        currentPage = (int) (personImageCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PERSON_IMAGE_DELETE)
    @Override
    public final String personImageDelete(@PathVariable final String id) {
        logger.debug("PersonImageListControllerImpl::personImageDelete");
        personImageService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + ImageMappingConstants.PERSON_IMAGE_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
