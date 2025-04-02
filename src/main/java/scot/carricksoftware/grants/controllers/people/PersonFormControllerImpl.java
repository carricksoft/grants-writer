/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.people.PersonCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class PersonFormControllerImpl implements PersonFormController {

    private static final Logger logger = LogManager.getLogger(PersonFormControllerImpl.class);

    private final PersonService personService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final PersonCommandConverterImpl personCommandConverter;
    private final PersonConverterImpl personConverter;
    private final Capitalisation capitalisation;
    private final PersonCommandValidator personCommandValidator;


    public PersonFormControllerImpl(PersonService personService,
                                    PersonCommandConverterImpl personCommandConverter,
                                    PersonConverterImpl personConverter,
                                    Capitalisation capitalisation, PersonCommandValidator personCommandValidator) {
        this.personService = personService;
        this.personCommandConverter = personCommandConverter;


        this.personConverter = personConverter;
        this.capitalisation = capitalisation;
        this.personCommandValidator = personCommandValidator;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_NEW)
    public final String getNewPerson(final Model model) {
        logger.debug("PersonFormControllerImpl::getNewPerson");
        model.addAttribute(AttributeConstants.PERSON_COMMAND, new PersonCommandImpl());
        return ViewConstants.PERSON_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_EDIT)
    public final String personEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("PersonFormControllerImpl::personEdit");
        model.addAttribute(AttributeConstants.PERSON_COMMAND, personService.findById(Long.valueOf(id)));
        return ViewConstants.PERSON_FORM;
    }


    @Override
    @PostMapping(MappingConstants.PERSON)
    public String saveOrUpdate(@Valid @ModelAttribute PersonCommand personCommand, BindingResult bindingResult, Model model) {
        logger.debug("PersonFormControllerImpl::saveOrUpdate");

        personCommandValidator.validate(personCommand, bindingResult);

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.PERSON_FORM;
        }

        cleanUp(personCommand);
        PersonCommand savedCommand = personService.savePersonCommand(personCommand);
        model.addAttribute(AttributeConstants.PERSON_COMMAND, savedCommand);
        return MappingConstants.REDIRECT + MappingConstants.PERSON_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    private void cleanUp(PersonCommand personCommand) {
        personCommand.setFirstName(capitalisation.getCapitalisation(personCommand.getFirstName()));
        personCommand.setLastName(capitalisation.getCapitalisation(personCommand.getLastName()));
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("PersonFormControllerImpl::saveOrUpdate");
        PersonCommand savedCommand = personConverter.convert(personService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PERSON_COMMAND, savedCommand);
        return ViewConstants.PERSON_FORM;
    }


}
