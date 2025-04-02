/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;

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
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.commands.images.ImageCommandImpl;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.ImageCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class ImageFormControllerImpl implements ImageFormController {

    private static final Logger logger = LogManager.getLogger(ImageFormControllerImpl.class);
    private final ImageService imageService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final ImageCommandConverterImpl imageCommandConverter;
    private final ImageConverterImpl imageConverter;
    private final ImageCommandValidator imageCommandValidator;


    public ImageFormControllerImpl(ImageService imageService,
                                   ImageCommandConverterImpl imageCommandConverter,
                                   ImageConverterImpl imageConverter,
                                   ImageCommandValidator imageCommandValidator) {
        this.imageService = imageService;
        this.imageCommandConverter = imageCommandConverter;


        this.imageConverter = imageConverter;
        this.imageCommandValidator = imageCommandValidator;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.IMAGE_NEW)
    public final String getNewImage(final Model model) {
        logger.debug("ImageFormControllerImpl::getNewImage");
        model.addAttribute(ImageAttributeConstants.IMAGE_COMMAND, new ImageCommandImpl());
        return ViewConstants.IMAGE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.IMAGE_EDIT)
    public final String imageEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("ImageFormControllerImpl::imageEdit");
        model.addAttribute(ImageAttributeConstants.IMAGE_COMMAND, imageService.findById(Long.valueOf(id)));
        return ViewConstants.IMAGE_FORM;
    }


    @Override
    @PostMapping(ImageMappingConstants.IMAGE)
    public String saveOrUpdate(@Valid @ModelAttribute ImageCommand imageCommand, BindingResult bindingResult, Model model) {
        logger.debug("ImageFormControllerImpl::saveOrUpdate");

        imageCommandValidator.validate(imageCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.IMAGE_FORM;
        }

        ImageCommand savedCommand = imageService.saveImageCommand(imageCommand);
        model.addAttribute(ImageAttributeConstants.IMAGE_COMMAND, savedCommand);
        return MappingConstants.REDIRECT + ImageMappingConstants.IMAGE_SHOW.replace("{id}", "" + savedCommand.getId());
    }



    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.IMAGE_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("ImageFormControllerImpl::saveOrUpdate");
        ImageCommand savedCommand = imageConverter.convert(imageService.findById(Long.valueOf(id)));
        model.addAttribute(ImageAttributeConstants.IMAGE_COMMAND, savedCommand);
        return ViewConstants.IMAGE_FORM;
    }


}
