/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.documenttext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.text.documenttext.DocumentTextService;

import static java.lang.Integer.max;

@Controller
public class DocumentTextListControllerImpl implements DocumentTextListController {

    private static final Logger logger = LogManager.getLogger(DocumentTextListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final DocumentTextService documentTextService;

    public DocumentTextListControllerImpl(ControllerHelper controllerHelper,
                                          DocumentTextService documentTextService) {
        this.controllerHelper = controllerHelper;
        this.documentTextService = documentTextService;
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.DOCUMENT_TEXT_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("DocumentTextListControllerImpl::getImagePage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(TextAttributeConstants.DOCUMENT_TEXTS, documentTextService.getPagedDocumentTexts(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.DOCUMENT_TEXT_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.DOCUMENT_TEXT_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("DocumentTextListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.DOCUMENT_TEXT_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("DocumentTextListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.DOCUMENT_TEXT_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("DocumentTextListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.DOCUMENT_TEXT_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("DocumentTextListControllerImpl::getLastPage");
        long imageCount = documentTextService.count();
        currentPage = (int) (imageCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.DOCUMENT_TEXT_DELETE)
    @Override
    public final String DocumentTextDelete(@PathVariable final String id) {
        logger.debug("DocumentTextListControllerImpl::imageDelete");
        documentTextService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + TextMappingConstants.DOCUMENT_TEXT;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
