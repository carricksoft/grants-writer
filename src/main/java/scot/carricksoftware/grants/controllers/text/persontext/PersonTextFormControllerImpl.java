/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.persontext;

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
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.commands.text.PersonTextCommandImpl;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.text.persontext.PersonTextService;
import scot.carricksoftware.grants.validators.text.PersonTextCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class PersonTextFormControllerImpl implements PersonTextFormController {

    private static final Logger logger = LogManager.getLogger(PersonTextFormControllerImpl.class);
    private final PersonTextService personTextService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final PersonTextCommandConverterImpl personTextCommandConverter;
    private final PersonTextConverterImpl personTextConverter;
    private final PersonTextCommandValidator personTextCommandValidator;
    private final PersonService personService;


    public PersonTextFormControllerImpl(PersonTextService personTextService,
                                        PersonTextCommandConverterImpl personTextCommandConverter,
                                        PersonTextConverterImpl personTextConverter,
                                        PersonTextCommandValidator personTextCommandValidator,
                                        PersonService personService) {
        this.personTextService = personTextService;
        this.personTextCommandConverter = personTextCommandConverter;


        this.personTextConverter = personTextConverter;
        this.personTextCommandValidator = personTextCommandValidator;
        this.personService = personService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PERSON_TEXT_NEW)
    public final String getNewPersonText(final Model model) {
        logger.debug("PersonTextFormControllerImpl::getNewPersonText");
        model.addAttribute(TextAttributeConstants.PERSON_TEXT_COMMAND, new PersonTextCommandImpl());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.PERSON_TEXT_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PERSON_TEXT_EDIT)
    public final String personTextEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("PersonTextFormControllerImpl::personTextEdit");
        model.addAttribute(TextAttributeConstants.PERSON_TEXT_COMMAND, personTextService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.PERSON_TEXT_FORM;
    }


    @Override
    @PostMapping(TextMappingConstants.PERSON_TEXT)
    public String saveOrUpdate(@Valid @ModelAttribute PersonTextCommand personTextCommand, BindingResult bindingResult, Model model) {
        logger.debug("PersonTextFormControllerImpl::saveOrUpdate");

        personTextCommandValidator.validate(personTextCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
            return ViewConstants.PERSON_TEXT_FORM;
        }

        PersonTextCommand savedCommand = personTextService.savePersonTextCommand(personTextCommand);
        model.addAttribute(TextAttributeConstants.PERSON_TEXT_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return MappingConstants.REDIRECT + TextMappingConstants.PERSON_TEXT_SHOW.replace("{id}", "" + savedCommand.getId());
    }



    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PERSON_TEXT_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("PersonTextFormControllerImpl::saveOrUpdate");
        PersonTextCommand savedCommand = personTextConverter.convert(personTextService.findById(Long.valueOf(id)));
        model.addAttribute(TextAttributeConstants.PERSON_TEXT_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.PERSON_TEXT_FORM;
    }


}
