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
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextConverterImpl;
import scot.carricksoftware.grants.services.text.documenttext.DocumentTextService;
import scot.carricksoftware.grants.validators.text.DocumentTextCommandValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DocumentTextFormControllerValidationTest {

    @SuppressWarnings("unused")
    private DocumentTextFormControllerImpl documentTextController;

    @Mock
    private DocumentTextService documentTextServiceMock;

    @Mock
    private DocumentTextCommandConverterImpl documentTextCommandConverterMock;

    @Mock
    private DocumentTextConverterImpl documentTextConverterMock;


    @Mock
    private DocumentTextCommand documentTextCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private DocumentTextCommandValidator documentTextCommandValidatorMock;

    @Mock
    private Model modelMock;


    @BeforeEach
    public void setUp() {
        documentTextController = new DocumentTextFormControllerImpl(documentTextServiceMock,
                documentTextCommandConverterMock,
                documentTextConverterMock,
                documentTextCommandValidatorMock);
    }


    @Test
    public void saveOrUpdateValidationTest() {
        when(documentTextServiceMock.saveDocumentTextCommand(any())).thenReturn(documentTextCommandMock);
        documentTextController.saveOrUpdate(documentTextCommandMock, bindingResultMock, modelMock);
        verify(documentTextCommandValidatorMock).validate(documentTextCommandMock, bindingResultMock);
    }


}