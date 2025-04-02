/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.placeimages;

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
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.commands.images.PlaceImageCommandImpl;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageConverterImpl;
import scot.carricksoftware.grants.services.images.placeimage.PlaceImageService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.validators.images.PlaceImageCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class PlaceImageFormControllerImpl implements PlaceImageFormController {

    private static final Logger logger = LogManager.getLogger(PlaceImageFormControllerImpl.class);
    private final PlaceImageService placeImageService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final PlaceImageCommandConverterImpl placeImageCommandConverter;
    private final PlaceImageConverterImpl placeImageConverter;
    private final PlaceImageCommandValidator placeImageCommandValidator;
    private final PlaceService placeService;


    public PlaceImageFormControllerImpl(PlaceImageService placeImageService,
                                        PlaceImageCommandConverterImpl placeImageCommandConverter,
                                        PlaceImageConverterImpl placeImageConverter,
                                        PlaceImageCommandValidator placeImageCommandValidator, PlaceService placeService) {
        this.placeImageService = placeImageService;
        this.placeImageCommandConverter = placeImageCommandConverter;


        this.placeImageConverter = placeImageConverter;
        this.placeImageCommandValidator = placeImageCommandValidator;
        this.placeService = placeService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PLACE_IMAGE_NEW)
    public final String getNewPlaceImage(final Model model) {
        logger.debug("PlaceImageFormControllerImpl::getNewPlaceImage");
        model.addAttribute(ImageAttributeConstants.PLACE_IMAGE_COMMAND, new PlaceImageCommandImpl());
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.PLACE_IMAGE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PLACE_IMAGE_EDIT)
    public final String placeImageEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("PlaceImageFormControllerImpl::placeImageEdit");
        model.addAttribute(ImageAttributeConstants.PLACE_IMAGE_COMMAND, placeImageService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.PLACE_IMAGE_FORM;
    }


    @Override
    @PostMapping(ImageMappingConstants.PLACE_IMAGE)
    public String saveOrUpdate(@Valid @ModelAttribute PlaceImageCommand placeImageCommand, BindingResult bindingResult, Model model) {
        logger.debug("PlaceImageFormControllerImpl::saveOrUpdate");

        placeImageCommandValidator.validate(placeImageCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
            return ViewConstants.PLACE_IMAGE_FORM;
        }

        PlaceImageCommand savedCommand = placeImageService.savePlaceImageCommand(placeImageCommand);
        model.addAttribute(ImageAttributeConstants.PLACE_IMAGE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return MappingConstants.REDIRECT + ImageMappingConstants.PLACE_IMAGE_SHOW.replace("{id}", "" + savedCommand.getId());
    }



    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.PLACE_IMAGE_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("PlaceImageFormControllerImpl::saveOrUpdate");
        PlaceImageCommand savedCommand = placeImageConverter.convert(placeImageService.findById(Long.valueOf(id)));
        model.addAttribute(ImageAttributeConstants.PLACE_IMAGE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.PLACE_IMAGE_FORM;
    }


}
