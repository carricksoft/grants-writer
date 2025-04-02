/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 22:25. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.places.countries;

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
import scot.carricksoftware.grants.services.places.countries.CountryService;


import static java.lang.Integer.max;

@Controller
public class CountryListControllerImpl implements CountryListController {

    private static final Logger logger = LogManager.getLogger(CountryListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final CountryService countryService;

    public CountryListControllerImpl(ControllerHelper controllerHelper,
                                     CountryService countryService) {
        this.controllerHelper = controllerHelper;
        this.countryService = countryService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getCountryPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.COUNTRIES, countryService.getPagedCountries(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.COUNTRY_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("CountryListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("CountryListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("CountryListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("CountryListControllerImpl::getLastPage");
        long countryCount = countryService.count();
        currentPage = (int) (countryCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_DELETE)
    @Override
    public final String countryDelete(@PathVariable final String id) {
        logger.debug("CountryListControllerImpl::countryDelete");
        countryService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + MappingConstants.COUNTRIES;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
