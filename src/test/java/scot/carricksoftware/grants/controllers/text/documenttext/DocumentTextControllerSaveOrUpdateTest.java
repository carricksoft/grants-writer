/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.documenttext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.commands.text.DocumentTextCommandImpl;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextConverterImpl;
import scot.carricksoftware.grants.services.text.documenttext.DocumentTextService;
import scot.carricksoftware.grants.validators.text.DocumentTextCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DocumentTextControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private DocumentTextFormControllerImpl documentTextController;

    @Mock
    private DocumentTextService documentTextServiceMock;

    @Mock
    private DocumentTextCommandConverterImpl documentTextCommandConverterMock;

    @Mock
    private DocumentTextConverterImpl documentTextConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private DocumentTextCommandValidator documentTextCommandValidatorMock;

    private DocumentTextCommand documentTextCommand;


    @BeforeEach
    public void setUp() {
        documentTextController = new DocumentTextFormControllerImpl(documentTextServiceMock,
                documentTextCommandConverterMock,
                documentTextConverterMock,
                documentTextCommandValidatorMock);
        documentTextCommand = new DocumentTextCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        documentTextCommand.setId(id);
        when(documentTextServiceMock.saveDocumentTextCommand(any(DocumentTextCommand.class))).thenReturn(documentTextCommand);
        assertEquals("redirect:/documentText/4/show", documentTextController.saveOrUpdate(documentTextCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        documentTextCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("text/documentText/form", documentTextController.saveOrUpdate(documentTextCommand, bindingResultMock, modelMock));
    }

}