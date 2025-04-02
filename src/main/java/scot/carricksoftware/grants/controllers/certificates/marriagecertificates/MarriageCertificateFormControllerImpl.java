/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.marriagecertificates;

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
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.MarriageCertificateCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class MarriageCertificateFormControllerImpl implements MarriageCertificateFormController {

    private static final Logger logger = LogManager.getLogger(MarriageCertificateFormControllerImpl.class);
    private final MarriageCertificateService marriageCertificateService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final MarriageCertificateCommandConverterImpl marriageCertificateCommandConverter;
    private final MarriageCertificateConverterImpl marriageCertificateConverter;
    private final MarriageCertificateCommandValidator marriageCertificateCommandValidator;
    private final PersonService personService;


    public MarriageCertificateFormControllerImpl(MarriageCertificateService marriageCertificateService,
                                                 MarriageCertificateCommandConverterImpl marriageCertificateCommandConverter,
                                                 MarriageCertificateConverterImpl marriageCertificateConverter,
                                                 MarriageCertificateCommandValidator marriageCertificateCommandValidator,
                                                 PersonService personService) {
        this.marriageCertificateService = marriageCertificateService;
        this.marriageCertificateCommandConverter = marriageCertificateCommandConverter;


        this.marriageCertificateConverter = marriageCertificateConverter;
        this.marriageCertificateCommandValidator = marriageCertificateCommandValidator;
        this.personService = personService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.MARRIAGE_CERTIFICATE_NEW)
    @Override
    public final String getNewMarriageCertificate(final Model model) {
        logger.debug("MarriageCertificateFormControllerImpl::getNewMarriageCertificate");
        model.addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, new MarriageCertificateCommandImpl());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.MARRIAGE_CERTIFICATE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.MARRIAGE_CERTIFICATE_EDIT)
    @Override
    public final String marriageCertificateEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("MarriageCertificateFormControllerImpl::marriageCertificateEdit");
        model.addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, marriageCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.MARRIAGE_CERTIFICATE_FORM;
    }


    @Override
    @PostMapping(MappingConstants.MARRIAGE_CERTIFICATE)
    public String saveOrUpdate(@Valid @ModelAttribute MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult, Model model) {
        logger.debug("MarriageCertificateFormControllerImpl::saveOrUpdate");

        marriageCertificateCommandValidator.validate(marriageCertificateCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
            return ViewConstants.MARRIAGE_CERTIFICATE_FORM;
        }

        MarriageCertificateCommand savedCommand = marriageCertificateService.saveMarriageCertificateCommand(marriageCertificateCommand);
        model.addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return MappingConstants.REDIRECT + MappingConstants.MARRIAGE_CERTIFICATE_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.MARRIAGE_CERTIFICATE_SHOW)
    @Override
    public String showById(@PathVariable String id, Model model) {
        logger.debug("MarriageCertificateFormControllerImpl::saveOrUpdate");
        MarriageCertificateCommand savedCommand = marriageCertificateConverter.convert(marriageCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.MARRIAGE_CERTIFICATE_FORM;
    }


}
