/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.deathcertificates;

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
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.DeathCertificateCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class DeathCertificateFormControllerImpl implements DeathCertificateFormController {

    private static final Logger logger = LogManager.getLogger(DeathCertificateFormControllerImpl.class);
    private final DeathCertificateService deathCertificateService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final DeathCertificateCommandConverterImpl deathCertificateCommandConverter;
    private final DeathCertificateConverterImpl deathCertificateConverter;
    private final DeathCertificateCommandValidator deathCertificateCommandValidator;
    private final PersonService personService;


    public DeathCertificateFormControllerImpl(DeathCertificateService deathCertificateService,
                                              DeathCertificateCommandConverterImpl deathCertificateCommandConverter,
                                              DeathCertificateConverterImpl deathCertificateConverter,
                                              DeathCertificateCommandValidator deathCertificateCommandValidator, PersonService personService) {
        this.deathCertificateService = deathCertificateService;
        this.deathCertificateCommandConverter = deathCertificateCommandConverter;


        this.deathCertificateConverter = deathCertificateConverter;
        this.deathCertificateCommandValidator = deathCertificateCommandValidator;
        this.personService = personService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATH_CERTIFICATE_NEW)
    @Override
    public final String getNewDeathCertificate(final Model model) {
        logger.debug("DeathCertificateFormControllerImpl::getNewDeathCertificate");
        model.addAttribute(AttributeConstants.DEATH_CERTIFICATE_COMMAND, new DeathCertificateCommandImpl());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.DEATH_CERTIFICATE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATH_CERTIFICATE_EDIT)
    @Override
    public final String deathCertificateEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("DeathCertificateFormControllerImpl::deathCertificateEdit");
        model.addAttribute(AttributeConstants.DEATH_CERTIFICATE_COMMAND, deathCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.DEATH_CERTIFICATE_FORM;
    }


    @Override
    @PostMapping(MappingConstants.DEATH_CERTIFICATE)
    public String saveOrUpdate(@Valid @ModelAttribute DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult, Model model) {
        logger.debug("DeathCertificateFormControllerImpl::saveOrUpdate");

        deathCertificateCommandValidator.validate(deathCertificateCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
            return ViewConstants.DEATH_CERTIFICATE_FORM;
        }

        DeathCertificateCommand savedCommand = deathCertificateService.saveDeathCertificateCommand(deathCertificateCommand);
        model.addAttribute(AttributeConstants.DEATH_CERTIFICATE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return MappingConstants.REDIRECT + MappingConstants.DEATH_CERTIFICATE_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATH_CERTIFICATE_SHOW)
    @Override
    public String showById(@PathVariable String id, Model model) {
        logger.debug("DeathCertificateFormControllerImpl::saveOrUpdate");
        DeathCertificateCommand savedCommand = deathCertificateConverter.convert(deathCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.DEATH_CERTIFICATE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.DEATH_CERTIFICATE_FORM;
    }


}
