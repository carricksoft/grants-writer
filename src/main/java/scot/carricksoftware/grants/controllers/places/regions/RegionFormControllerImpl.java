/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;

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
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.commands.places.regions.RegionCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.services.places.countries.CountryService;
import scot.carricksoftware.grants.services.places.regions.RegionService;
import scot.carricksoftware.grants.validators.places.RegionCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class RegionFormControllerImpl implements RegionFormController {

    private static final Logger logger = LogManager.getLogger(RegionFormControllerImpl.class);
    private final RegionService regionService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final RegionCommandConverterImpl regionCommandConverter;
    private final RegionConverterImpl regionConverter;
    private final Capitalisation capitalisation;
    private final RegionCommandValidator regionCommandValidator;
    private final CountryService countryService;


    public RegionFormControllerImpl(RegionService regionService,
                                    RegionCommandConverterImpl regionCommandConverter,
                                    RegionConverterImpl regionConverter,
                                    Capitalisation capitalisation, RegionCommandValidator regionCommandValidator,
                                    CountryService countryService) {
        this.regionService = regionService;
        this.regionCommandConverter = regionCommandConverter;


        this.regionConverter = regionConverter;
        this.capitalisation = capitalisation;
        this.regionCommandValidator = regionCommandValidator;
        this.countryService = countryService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_NEW)
    public final String getNewRegion(final Model model) {
        logger.debug("RegionFormControllerImpl::getNewRegion");
        model.addAttribute(AttributeConstants.REGION_COMMAND, new RegionCommandImpl());
        model.addAttribute(AttributeConstants.COUNTRIES, countryService.findAll());
        return ViewConstants.REGION_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_EDIT)
    public final String regionEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("RegionFormControllerImpl::regionEdit");
        model.addAttribute(AttributeConstants.REGION_COMMAND, regionService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.COUNTRIES, countryService.findAll());
        return ViewConstants.REGION_FORM;
    }


    @Override
    @PostMapping(MappingConstants.REGION)
    public String saveOrUpdate(@Valid @ModelAttribute RegionCommand regionCommand, BindingResult bindingResult, Model model) {
        logger.debug("RegionFormControllerImpl::saveOrUpdate");

        regionCommandValidator.validate(regionCommand, bindingResult);

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.COUNTRIES, countryService.findAll());
            return ViewConstants.REGION_FORM;
        }

        cleanUp(regionCommand);
        RegionCommand savedCommand = regionService.saveRegionCommand(regionCommand);
        model.addAttribute(AttributeConstants.REGION_COMMAND, savedCommand);
        return MappingConstants.REDIRECT + MappingConstants.REGION_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    private void cleanUp(RegionCommand regionCommand) {
        regionCommand.setName(capitalisation.getCapitalisation(regionCommand.getName()));
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("RegionFormControllerImpl::saveOrUpdate");
        RegionCommand regionCommand = regionConverter.convert(regionService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.REGION_COMMAND, regionCommand);
        model.addAttribute(AttributeConstants.COUNTRIES, countryService.findAll());
        return ViewConstants.REGION_FORM;
    }


}
