/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;

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
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.commands.places.countries.CountryCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.services.places.countries.CountryService;
import scot.carricksoftware.grants.validators.places.CountryCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class CountryFormControllerImpl implements CountryFormController {

    private static final Logger logger = LogManager.getLogger(CountryFormControllerImpl.class);
    private final CountryService countryService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final CountryCommandConverterImpl countryCommandConverter;
    private final CountryConverterImpl countryConverter;
    private final Capitalisation capitalisation;
    private final CountryCommandValidator countryCommandValidator;


    public CountryFormControllerImpl(CountryService countryService,
                                     CountryCommandConverterImpl countryCommandConverter,
                                     CountryConverterImpl countryConverter,
                                     Capitalisation capitalisation, CountryCommandValidator countryCommandValidator) {
        this.countryService = countryService;
        this.countryCommandConverter = countryCommandConverter;


        this.countryConverter = countryConverter;
        this.capitalisation = capitalisation;
        this.countryCommandValidator = countryCommandValidator;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_NEW)
    public final String getNewCountry(final Model model) {
        logger.debug("CountryFormControllerImpl::getNewCountry");
        model.addAttribute(AttributeConstants.COUNTRY_COMMAND, new CountryCommandImpl());
        return ViewConstants.COUNTRY_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_EDIT)
    public final String countryEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("CountryFormControllerImpl::countryEdit");
        model.addAttribute(AttributeConstants.COUNTRY_COMMAND, countryService.findById(Long.valueOf(id)));
        return ViewConstants.COUNTRY_FORM;
    }


    @Override
    @PostMapping(MappingConstants.COUNTRY)
    public String saveOrUpdate(@Valid @ModelAttribute CountryCommand countryCommand, BindingResult bindingResult, Model model) {
        logger.debug("CountryFormControllerImpl::saveOrUpdate");

        countryCommandValidator.validate(countryCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.COUNTRY_FORM;
        }

        cleanUp(countryCommand);
        CountryCommand savedCommand = countryService.saveCountryCommand(countryCommand);
        model.addAttribute(AttributeConstants.COUNTRY_COMMAND, savedCommand);
        return MappingConstants.REDIRECT + MappingConstants.COUNTRY_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    private void cleanUp(CountryCommand countryCommand) {
        countryCommand.setName(capitalisation.getCapitalisation(countryCommand.getName()));
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("CountryFormControllerImpl::saveOrUpdate");
        CountryCommand savedCommand = countryConverter.convert(countryService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.COUNTRY_COMMAND, savedCommand);
        return ViewConstants.COUNTRY_FORM;
    }


}
