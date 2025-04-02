/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.divorcecertificates;

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
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.divorcecertificates.DivorceCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.DivorceCertificateCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class DivorceCertificateFormControllerImpl implements DivorceCertificateFormController {

    private static final Logger logger = LogManager.getLogger(DivorceCertificateFormControllerImpl.class);
    private final DivorceCertificateService divorceCertificateService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final DivorceCertificateCommandConverterImpl divorceCertificateCommandConverter;
    private final DivorceCertificateConverterImpl divorceCertificateConverter;
    private final DivorceCertificateCommandValidator divorceCertificateCommandValidator;
    private final PersonService personService;


    public DivorceCertificateFormControllerImpl(DivorceCertificateService divorceCertificateService,
                                                DivorceCertificateCommandConverterImpl divorceCertificateCommandConverter,
                                                DivorceCertificateConverterImpl divorceCertificateConverter,
                                                DivorceCertificateCommandValidator divorceCertificateCommandValidator, PersonService personService) {
        this.divorceCertificateService = divorceCertificateService;
        this.divorceCertificateCommandConverter = divorceCertificateCommandConverter;


        this.divorceCertificateConverter = divorceCertificateConverter;
        this.divorceCertificateCommandValidator = divorceCertificateCommandValidator;
        this.personService = personService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_NEW)
    @Override
    public final String getNewDivorceCertificate(final Model model) {
        logger.debug("DivorceCertificateFormControllerImpl::getNewDivorceCertificate");
        model.addAttribute(AttributeConstants.DIVORCE_CERTIFICATE_COMMAND, new DivorceCertificateCommandImpl());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.DIVORCE_CERTIFICATE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_EDIT)
    @Override
    public final String divorceCertificateEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("DivorceCertificateFormControllerImpl::divorceCertificateEdit");
        model.addAttribute(AttributeConstants.DIVORCE_CERTIFICATE_COMMAND, divorceCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.DIVORCE_CERTIFICATE_FORM;
    }


    @Override
    @PostMapping(MappingConstants.DIVORCE_CERTIFICATE)
    public String saveOrUpdate(@Valid @ModelAttribute DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult, Model model) {
        logger.debug("DivorceCertificateFormControllerImpl::saveOrUpdate");

        divorceCertificateCommandValidator.validate(divorceCertificateCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
            return ViewConstants.DIVORCE_CERTIFICATE_FORM;
        }

        DivorceCertificateCommand savedCommand = divorceCertificateService.saveDivorceCertificateCommand(divorceCertificateCommand);
        model.addAttribute(AttributeConstants.DIVORCE_CERTIFICATE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return MappingConstants.REDIRECT + MappingConstants.DIVORCE_CERTIFICATE_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DIVORCE_CERTIFICATE_SHOW)
    @Override
    public String showById(@PathVariable String id, Model model) {
        logger.debug("DivorceCertificateFormControllerImpl::saveOrUpdate");
        DivorceCertificateCommand savedCommand = divorceCertificateConverter.convert(divorceCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.DIVORCE_CERTIFICATE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.DIVORCE_CERTIFICATE_FORM;
    }


}
