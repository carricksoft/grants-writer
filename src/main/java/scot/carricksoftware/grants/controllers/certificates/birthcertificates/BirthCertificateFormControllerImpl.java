/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.birthcertificates;

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
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.BirthCertificateCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class BirthCertificateFormControllerImpl implements BirthCertificateFormController {

    private static final Logger logger = LogManager.getLogger(BirthCertificateFormControllerImpl.class);
    private final BirthCertificateService birthCertificateService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final BirthCertificateCommandConverterImpl birthCertificateCommandConverter;
    private final BirthCertificateConverterImpl birthCertificateConverter;
    private final BirthCertificateCommandValidator birthCertificateCommandValidator;
    private final PersonService personService;


    public BirthCertificateFormControllerImpl(BirthCertificateService birthCertificateService,
                                              BirthCertificateCommandConverterImpl birthCertificateCommandConverter,
                                              BirthCertificateConverterImpl birthCertificateConverter,
                                              BirthCertificateCommandValidator birthCertificateCommandValidator,
                                              PersonService personService) {
        this.birthCertificateService = birthCertificateService;
        this.birthCertificateCommandConverter = birthCertificateCommandConverter;


        this.birthCertificateConverter = birthCertificateConverter;
        this.birthCertificateCommandValidator = birthCertificateCommandValidator;
        this.personService = personService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTH_CERTIFICATE_NEW)
    @Override
    public final String getNewBirthCertificate(final Model model) {
        logger.debug("BirthCertificateFormControllerImpl::getNewBirthCertificate");
        model.addAttribute(AttributeConstants.BIRTH_CERTIFICATE_COMMAND, new BirthCertificateCommandImpl());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.BIRTH_CERTIFICATE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTH_CERTIFICATE_EDIT)
    @Override
    public final String birthCertificateEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("BirthCertificateFormControllerImpl::birthCertificateEdit");
        model.addAttribute(AttributeConstants.BIRTH_CERTIFICATE_COMMAND, birthCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.BIRTH_CERTIFICATE_FORM;
    }


    @Override
    @PostMapping(MappingConstants.BIRTH_CERTIFICATE)
    public String saveOrUpdate(@Valid @ModelAttribute BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult, Model model) {
        logger.debug("BirthCertificateFormControllerImpl::saveOrUpdate");

        birthCertificateCommandValidator.validate(birthCertificateCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
            return ViewConstants.BIRTH_CERTIFICATE_FORM;
        }

        BirthCertificateCommand savedCommand = birthCertificateService.saveBirthCertificateCommand(birthCertificateCommand);
        model.addAttribute(AttributeConstants.BIRTH_CERTIFICATE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return MappingConstants.REDIRECT + MappingConstants.BIRTH_CERTIFICATE_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTH_CERTIFICATE_SHOW)
    @Override
    public String showById(@PathVariable String id, Model model) {
        logger.debug("BirthCertificateFormControllerImpl::saveOrUpdate");
        BirthCertificateCommand savedCommand = birthCertificateConverter.convert(birthCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.BIRTH_CERTIFICATE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.BIRTH_CERTIFICATE_FORM;
    }


}
