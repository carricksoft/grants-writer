/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.deathcertificates;

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
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;

import static java.lang.Integer.max;

@Controller
public class DeathCertificateListControllerImpl implements DeathCertificateListController {

    private static final Logger logger = LogManager.getLogger(DeathCertificateListControllerImpl.class);
    private final DeathCertificateService deathCertificateService;

    private int currentPage = 0;
    private final ControllerHelper controllerHelper;

    public DeathCertificateListControllerImpl(ControllerHelper controllerHelper,
                                              DeathCertificateService deathCertificateService) {
        this.controllerHelper = controllerHelper;
        this.deathCertificateService = deathCertificateService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATH_CERTIFICATE_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("DeathCertificateListControllerImpl::getCensusPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.DEATH_CERTIFICATES, deathCertificateService.getPagedDeathCertificates(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.DEATH_CERTIFICATE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATH_CERTIFICATE_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("DeathCertificateListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATH_CERTIFICATE_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("DeathCertificateListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATH_CERTIFICATE_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("DeathCertificateListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATH_CERTIFICATE_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("DeathCertificateListControllerImpl::getLastPage");
        long certificateCount = deathCertificateService.count();
        currentPage = (int) (certificateCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATH_CERTIFICATE_DELETE)
    @Override
    public final String deathCertificateDelete(@PathVariable final String id) {
        logger.debug("DeathCertificateControllerImpl::censusDelete");
        deathCertificateService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + MappingConstants.DEATH_CERTIFICATE_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
