/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.persontext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.text.persontext.PersonTextService;


import static java.lang.Integer.max;

@Controller
public class PersonTextListControllerImpl implements PersonTextListController {

    private static final Logger logger = LogManager.getLogger(PersonTextListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final PersonTextService personTextService;

    public PersonTextListControllerImpl(ControllerHelper controllerHelper,
                                        PersonTextService personTextService) {
        this.controllerHelper = controllerHelper;
        this.personTextService = personTextService;
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PERSON_TEXT_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonTextListControllerImpl::getImagePage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(TextAttributeConstants.PERSON_TEXTS, personTextService.getPagedPersonTexts(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.PERSON_TEXT_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PERSON_TEXT_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("PersonTextListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PERSON_TEXT_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("PersonTextListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PERSON_TEXT_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("PersonTextListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PERSON_TEXT_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("PersonTextListControllerImpl::getLastPage");
        long imageCount = personTextService.count();
        currentPage = (int) (imageCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PERSON_TEXT_DELETE)
    @Override
    public final String PersonTextDelete(@PathVariable final String id) {
        logger.debug("PersonTextListControllerImpl::imageDelete");
        personTextService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + TextMappingConstants.PERSON_TEXT_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }
    
}
