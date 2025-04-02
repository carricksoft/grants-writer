/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.divorcecertificates;

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
import scot.carricksoftware.grants.services.certificates.divorcecertificates.DivorceCertificateService;

import static java.lang.Integer.max;

@Controller
public class DivorceCertificateListControllerImpl implements DivorceCertificateListController {

    private static final Logger logger = LogManager.getLogger(DivorceCertificateListControllerImpl.class);
    private final DivorceCertificateService divorceCertificateService;

    private int currentPage = 0;
    private final ControllerHelper controllerHelper;

    public DivorceCertificateListControllerImpl(ControllerHelper controllerHelper,
                                                DivorceCertificateService divorceCertificateService) {
        this.controllerHelper = controllerHelper;
        this.divorceCertificateService = divorceCertificateService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("DivorceCertificateListControllerImpl::getCensusPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.DIVORCE_CERTIFICATES, divorceCertificateService.getPagedDivorceCertificates(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.DIVORCE_CERTIFICATE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("DivorceCertificateListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("DivorceCertificateListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("DivorceCertificateListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("DivorceCertificateListControllerImpl::getLastPage");
        long certificateCount = divorceCertificateService.count();
        currentPage = (int) (certificateCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_DELETE)
    @Override
    public final String divorceCertificateDelete(@PathVariable final String id) {
        logger.debug("DivorceCertificateControllerImpl::censusDelete");
        divorceCertificateService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + MappingConstants.DIVORCE_CERTIFICATE_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
