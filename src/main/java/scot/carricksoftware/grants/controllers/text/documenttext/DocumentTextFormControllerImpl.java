/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.documenttext;

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
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.commands.text.DocumentTextCommandImpl;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextConverterImpl;
import scot.carricksoftware.grants.services.text.documenttext.DocumentTextService;
import scot.carricksoftware.grants.validators.text.DocumentTextCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class DocumentTextFormControllerImpl implements DocumentTextFormController {

    private static final Logger logger = LogManager.getLogger(DocumentTextFormControllerImpl.class);
    private final DocumentTextService documentTextService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final DocumentTextCommandConverterImpl documentTextCommandConverter;
    private final DocumentTextConverterImpl documentTextConverter;
    private final DocumentTextCommandValidator documentTextCommandValidator;


    public DocumentTextFormControllerImpl(DocumentTextService documentTextService,
                                          DocumentTextCommandConverterImpl documentTextCommandConverter,
                                          DocumentTextConverterImpl documentTextConverter,
                                          DocumentTextCommandValidator documentTextCommandValidator) {
        this.documentTextService = documentTextService;
        this.documentTextCommandConverter = documentTextCommandConverter;


        this.documentTextConverter = documentTextConverter;
        this.documentTextCommandValidator = documentTextCommandValidator;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.DOCUMENT_TEXT_NEW)
    public final String getNewDocumentText(final Model model) {
        logger.debug("DocumentTextFormControllerImpl::getNewDocumentText");
        model.addAttribute(TextAttributeConstants.DOCUMENT_TEXT_COMMAND, new DocumentTextCommandImpl());
        return ViewConstants.DOCUMENT_TEXT_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.DOCUMENT_TEXT_EDIT)
    public final String documentTextEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("DocumentTextFormControllerImpl::documentTextEdit");
        model.addAttribute(TextAttributeConstants.DOCUMENT_TEXT_COMMAND, documentTextService.findById(Long.valueOf(id)));
        return ViewConstants.DOCUMENT_TEXT_FORM;
    }


    @Override
    @PostMapping(TextMappingConstants.DOCUMENT_TEXT)
    public String saveOrUpdate(@Valid @ModelAttribute DocumentTextCommand documentTextCommand, BindingResult bindingResult, Model model) {
        logger.debug("DocumentTextFormControllerImpl::saveOrUpdate");

        documentTextCommandValidator.validate(documentTextCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.DOCUMENT_TEXT_FORM;
        }

        DocumentTextCommand savedCommand = documentTextService.saveDocumentTextCommand(documentTextCommand);
        model.addAttribute(TextAttributeConstants.DOCUMENT_TEXT_COMMAND, savedCommand);
        return MappingConstants.REDIRECT + TextMappingConstants.DOCUMENT_TEXT_SHOW.replace("{id}", "" + savedCommand.getId());
    }



    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.DOCUMENT_TEXT_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("DocumentTextFormControllerImpl::saveOrUpdate");
        DocumentTextCommand savedCommand = documentTextConverter.convert(documentTextService.findById(Long.valueOf(id)));
        model.addAttribute(TextAttributeConstants.DOCUMENT_TEXT_COMMAND, savedCommand);
        return ViewConstants.DOCUMENT_TEXT_FORM;
    }


}
