/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 22:25. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.people;

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
import scot.carricksoftware.grants.services.people.PersonService;

import static java.lang.Integer.max;

@Controller
public class PersonListControllerImpl implements PersonListController {

    private static final Logger logger = LogManager.getLogger(PersonListControllerImpl.class);

    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final PersonService personService;

    public PersonListControllerImpl(ControllerHelper controllerHelper,
                                    PersonService personService) {
        this.controllerHelper = controllerHelper;
        this.personService = personService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getPersonPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(AttributeConstants.PEOPLE, personService.getPagedPersons(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.PEOPLE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("PersonListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("PersonListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("PersonListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("PersonListControllerImpl::getLastPage");
        long personCount = personService.count();
        currentPage = (int) (personCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_DELETE)
    @Override
    public final String personDelete(@PathVariable final String id) {
        logger.debug("PersonListControllerImpl::personDelete");
        personService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + MappingConstants.PEOPLE;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
