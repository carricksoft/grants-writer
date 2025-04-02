/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.personImages;

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
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.commands.images.PersonImageCommandImpl;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageConverterImpl;
import scot.carricksoftware.grants.services.images.personimage.PersonImageService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.images.PersonImageCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class PersonImageFormControllerImpl implements PersonImageFormController {

    private static final Logger logger = LogManager.getLogger(PersonImageFormControllerImpl.class);
    private final PersonImageService personImageService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final PersonImageCommandConverterImpl personImageCommandConverter;
    private final PersonImageConverterImpl personImageConverter;
    private final PersonImageCommandValidator personImageCommandValidator;
    private final PersonService personService;


    public PersonImageFormControllerImpl(PersonImageService personImageService,
                                         PersonImageCommandConverterImpl personImageCommandConverter,
                                         PersonImageConverterImpl personImageConverter,
                                         PersonImageCommandValidator personImageCommandValidator, PersonService personService) {
        this.personImageService = personImageService;
        this.personImageCommandConverter = personImageCommandConverter;


        this.personImageConverter = personImageConverter;
        this.personImageCommandValidator = personImageCommandValidator;
        this.personService = personService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PERSON_IMAGE_NEW)
    public final String getNewPersonImage(final Model model) {
        logger.debug("PersonImageFormControllerImpl::getNewPersonImage");
        model.addAttribute(ImageAttributeConstants.PERSON_IMAGE_COMMAND, new PersonImageCommandImpl());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.PERSON_IMAGE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PERSON_IMAGE_EDIT)
    public final String personImageEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("PersonImageFormControllerImpl::personImageEdit");
        model.addAttribute(ImageAttributeConstants.PERSON_IMAGE_COMMAND, personImageService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.PERSON_IMAGE_FORM;
    }


    @Override
    @PostMapping(ImageMappingConstants.PERSON_IMAGE)
    public String saveOrUpdate(@Valid @ModelAttribute PersonImageCommand personImageCommand, BindingResult bindingResult, Model model) {
        logger.debug("PersonImageFormControllerImpl::saveOrUpdate");

        personImageCommandValidator.validate(personImageCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
            return ViewConstants.PERSON_IMAGE_FORM;
        }

        PersonImageCommand savedCommand = personImageService.savePersonImageCommand(personImageCommand);
        model.addAttribute(ImageAttributeConstants.PERSON_IMAGE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return MappingConstants.REDIRECT + ImageMappingConstants.PERSON_IMAGE_SHOW.replace("{id}", "" + savedCommand.getId());
    }



    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PERSON_IMAGE_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("PersonImageFormControllerImpl::saveOrUpdate");
        PersonImageCommand savedCommand = personImageConverter.convert(personImageService.findById(Long.valueOf(id)));
        model.addAttribute(ImageAttributeConstants.PERSON_IMAGE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.PERSON_IMAGE_FORM;
    }


}
