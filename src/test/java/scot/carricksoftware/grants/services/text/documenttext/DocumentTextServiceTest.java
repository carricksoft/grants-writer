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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextConverterImpl;
import scot.carricksoftware.grants.domains.text.DocumentText;
import scot.carricksoftware.grants.repositories.text.DocumentTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomDocumentText;


@ExtendWith(MockitoExtension.class)
public class DocumentTextServiceTest {

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

    @Mock
    Page<DocumentText> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        documentTextService.deleteById(id);
        verify(documentTextRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(documentTextRepositoryMock.count()).thenReturn(result);
        assertEquals(result, documentTextService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<DocumentText> result = new ArrayList<>();
        DocumentText documentText = GetRandomDocumentText();
        result.add(documentText);
        when(pageMock.getContent()).thenReturn(result);
        when(documentTextRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, documentTextService.getPagedDocumentTexts(0));
    }
    

}