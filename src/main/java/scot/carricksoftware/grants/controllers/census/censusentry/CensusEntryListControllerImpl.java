/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:07. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.censusentry;

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
import scot.carricksoftware.grants.services.census.CensusEntryService;

import static java.lang.Integer.max;

@Controller
public class CensusEntryListControllerImpl implements CensusEntryListController {

    private static final Logger logger = LogManager.getLogger(CensusEntryListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final CensusEntryService censusEntryService;


    public CensusEntryListControllerImpl(ControllerHelper controllerHelper,
                                         CensusEntryService censusEntryService) {
        this.controllerHelper = controllerHelper;
        this.censusEntryService = censusEntryService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_ENTRY_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getCensusEntryPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.CENSUS_ENTRIES, censusEntryService.getPagedCensusEntries(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.CENSUS_ENTRY_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_ENTRY_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("CensusEntryListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_ENTRY_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("CensusEntryListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_ENTRY_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("CensusEntryListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_ENTRY_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("CensusEntryListControllerImpl::getLastPage");
        long censusEntryCount = censusEntryService.count();
        currentPage = (int) (censusEntryCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_ENTRY_DELETE)
    @Override
    public final String censusEntryDelete(@PathVariable final String id) {
        logger.debug("CensusEntryListControllerImpl::censusEntryDelete");
        censusEntryService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + MappingConstants.CENSUS_ENTRY_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
