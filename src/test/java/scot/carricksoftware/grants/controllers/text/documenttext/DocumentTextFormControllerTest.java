/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.documenttext;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.constants.TextAttributeConstants;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextConverterImpl;
import scot.carricksoftware.grants.domains.text.DocumentText;
import scot.carricksoftware.grants.services.text.documenttext.DocumentTextService;
import scot.carricksoftware.grants.validators.text.DocumentTextCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomDocumentText;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomDocumentTextCommand;


@ExtendWith(MockitoExtension.class)
public class DocumentTextFormControllerTest {

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
    private DocumentTextCommandValidator documentTextCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        documentTextController = new DocumentTextFormControllerImpl(documentTextServiceMock,
                documentTextCommandConverterMock,
                documentTextConverterMock,
                documentTextCommandValidatorMock);
    }

    @Test
    public void getNewDocumentTextTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("text/documentText/form", documentTextController.getNewDocumentText(modelMock));
        verify(modelMock).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertEquals("documentTextCommand", stringCaptor.getValue());
        assertEquals("DocumentTextCommandImpl", objectCaptor.getValue().getClass().getSimpleName());
    }

    @Test
    public void documentTextEditTestEditTest() {
        Long id = GetRandomLong();
        DocumentText documentText = GetRandomDocumentText();
        when(documentTextServiceMock.findById(id)).thenReturn(documentText);

        assertEquals("text/documentText/form", documentTextController.documentTextEdit(id + "", modelMock));
        verify(modelMock).addAttribute(TextAttributeConstants.DOCUMENT_TEXT_COMMAND, documentText);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        DocumentText documentText = GetRandomDocumentText();
        DocumentTextCommand documentTextCommand = GetRandomDocumentTextCommand();

        when(documentTextServiceMock.findById(id)).thenReturn(documentText);
        when(documentTextConverterMock.convert(documentText)).thenReturn(documentTextCommand);
        assertEquals("text/documentText/form", documentTextController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(TextAttributeConstants.DOCUMENT_TEXT_COMMAND, documentTextCommand);
    }

}