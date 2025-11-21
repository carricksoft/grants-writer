/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.text;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.text.DocumentText;
import scot.carricksoftware.grantswriter.repositories.text.DocumentTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
class DocumentTextServiceTest {

    private DocumentTextService documentTextService;

    @Mock
    private DocumentTextRepository documentTextRepositoryMock;

    @BeforeEach
    void setUp() {
        documentTextService = new DocumentTextServiceImpl(documentTextRepositoryMock);
    }

    @Test
    void findAllTest() {
        List<DocumentText> documentTextList = new ArrayList<>();
        documentTextList.add(new DocumentText());
        when(documentTextRepositoryMock.findAll()).thenReturn(documentTextList);
        assertEquals(documentTextList, documentTextService.findAll());
    }


    @Test
    void findByIdTest() {
        Long id = GetRandomLong();
        DocumentText documentText = new DocumentText();
        when(documentTextRepositoryMock.findById(id)).thenReturn(documentText);
        assertEquals(documentText, documentTextService.findById(id));
    }
}