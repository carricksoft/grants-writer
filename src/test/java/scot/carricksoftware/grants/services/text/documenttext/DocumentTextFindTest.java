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
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextConverterImpl;
import scot.carricksoftware.grants.domains.text.DocumentText;
import scot.carricksoftware.grants.repositories.text.DocumentTextRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomDocumentText;

@ExtendWith(MockitoExtension.class)
public class DocumentTextFindTest {

    DocumentTextService documentTextService;

    @Mock
    DocumentTextRepository documentTextRepositoryMock;

    @Mock
    DocumentTextConverterImpl documentTextConverterMock;

    @Mock
    DocumentTextCommandConverterImpl documentTextCommandConverterMock;

    @BeforeEach
    public void setUp() {
        documentTextService = new DocumentTextServiceImpl(documentTextRepositoryMock,
                documentTextConverterMock,
                documentTextCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<DocumentText> countries = new ArrayList<>();
        countries.add(GetRandomDocumentText());
        when(documentTextRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, documentTextService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        DocumentText documentText = GetRandomDocumentText();
        Optional<DocumentText> documentTextOptional = Optional.of(documentText);
        when(documentTextRepositoryMock.findById(id)).thenReturn(documentTextOptional);
        assertEquals(documentText, documentTextService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<DocumentText> empty = Optional.empty();
        when(documentTextRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(documentTextService.findById(id));
    }

}