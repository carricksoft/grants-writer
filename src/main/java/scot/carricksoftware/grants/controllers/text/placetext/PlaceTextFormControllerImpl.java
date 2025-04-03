/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.placetext;

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
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.commands.text.PlaceTextCommandImpl;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextConverterImpl;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.services.text.placetext.PlaceTextService;
import scot.carricksoftware.grants.validators.text.PlaceTextCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class PlaceTextFormControllerImpl implements PlaceTextFormController {

    private static final Logger logger = LogManager.getLogger(PlaceTextFormControllerImpl.class);
    private final PlaceTextService placeTextService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final PlaceTextCommandConverterImpl placeTextCommandConverter;
    private final PlaceTextConverterImpl placeTextConverter;
    private final PlaceTextCommandValidator placeTextCommandValidator;
    private final PlaceService placeService;


    public PlaceTextFormControllerImpl(PlaceTextService placeTextService,
                                       PlaceTextCommandConverterImpl placeTextCommandConverter,
                                       PlaceTextConverterImpl placeTextConverter,
                                       PlaceTextCommandValidator placeTextCommandValidator,
                                       PlaceService placeService) {
        this.placeTextService = placeTextService;
        this.placeTextCommandConverter = placeTextCommandConverter;


        this.placeTextConverter = placeTextConverter;
        this.placeTextCommandValidator = placeTextCommandValidator;
        this.placeService = placeService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PLACE_TEXT_NEW)
    public final String getNewPlaceText(final Model model) {
        logger.debug("PlaceTextFormControllerImpl::getNewPlaceText");
        model.addAttribute(TextAttributeConstants.PLACE_TEXT_COMMAND, new PlaceTextCommandImpl());
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.PLACE_TEXT_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PLACE_TEXT_EDIT)
    public final String placeTextEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("PlaceTextFormControllerImpl::placeTextEdit");
        model.addAttribute(TextAttributeConstants.PLACE_TEXT_COMMAND, placeTextService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.PLACE_TEXT_FORM;
    }


    @Override
    @PostMapping(TextMappingConstants.PLACE_TEXT)
    public String saveOrUpdate(@Valid @ModelAttribute PlaceTextCommand placeTextCommand, BindingResult bindingResult, Model model) {
        logger.debug("PlaceTextFormControllerImpl::saveOrUpdate");

        placeTextCommandValidator.validate(placeTextCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
            return ViewConstants.PLACE_TEXT_FORM;
        }

        PlaceTextCommand savedCommand = placeTextService.savePlaceTextCommand(placeTextCommand);
        model.addAttribute(TextAttributeConstants.PLACE_TEXT_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return MappingConstants.REDIRECT + TextMappingConstants.PLACE_TEXT_SHOW.replace("{id}", "" + savedCommand.getId());
    }



    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.PLACE_TEXT_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("PlaceTextFormControllerImpl::saveOrUpdate");
        PlaceTextCommand savedCommand = placeTextConverter.convert(placeTextService.findById(Long.valueOf(id)));
        model.addAttribute(TextAttributeConstants.PLACE_TEXT_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.PLACE_TEXT_FORM;
    }


}
