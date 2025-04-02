/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.documenttext;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.commands.text.DocumentTextCommandImpl;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextConverterImpl;
import scot.carricksoftware.grants.domains.text.DocumentText;
import scot.carricksoftware.grants.repositories.text.DocumentTextRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomDocumentText;


@ExtendWith(MockitoExtension.class)
public class DocumentTextSaveTest {

    DocumentTextService documentTextService;

    @Mock
    DocumentTextRepository documentTextRepositoryMock;

    @Mock
    DocumentTextConverterImpl documentTextConverterImplMock;

    @Mock
    DocumentTextCommandConverterImpl documentTextCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        documentTextService = new DocumentTextServiceImpl(documentTextRepositoryMock,
                documentTextConverterImplMock,
                documentTextCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        DocumentText documentText = new DocumentText();

        when(documentTextRepositoryMock.save(documentText)).thenReturn(documentText);

        assertEquals(documentText, documentTextService.save(documentText));
    }

    @Test
    public void saveDocumentTextCommandTest() {
        DocumentText documentText = GetRandomDocumentText();
        DocumentTextCommand documentTextCommand = new DocumentTextCommandImpl();
        when(documentTextCommandConverterImplMock.convert(documentTextCommand)).thenReturn(documentText);
        when(documentTextRepositoryMock.save(documentText)).thenReturn(documentText);
        when(documentTextConverterImplMock.convert((documentText))).thenReturn(documentTextCommand);

        assertEquals(documentTextCommand, documentTextService.saveDocumentTextCommand(documentTextCommand));
    }


}