/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.domains.images.DocumentImage;
import scot.carricksoftware.grantswriter.domains.text.DocumentText;
import scot.carricksoftware.grantswriter.repositories.images.DocumentImageRepository;
import scot.carricksoftware.grantswriter.repositories.text.DocumentTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
class CombinedDocumentServiceTest {

    private CombinedDocumentService service;

    @Mock
    DocumentTextRepository documentTextRepositoryMock;

    @Mock
    DocumentImageRepository documentImageRepositoryMock;

    private List<DocumentText> documentTextList;
    private List<DocumentImage> documentImageList;
    private final String order = GetRandomString();
    private final Long Id = GetRandomLong();
    private final DocumentText documentText = new DocumentText();
    private final DocumentImage documentImage = new DocumentImage();

    @BeforeEach
    void setUp() {
        service = new CombinedDocumentServiceImpl(documentTextRepositoryMock, documentImageRepositoryMock);
        documentTextList = new ArrayList<>();
        documentImageList = new ArrayList<>();

    }

    @Test
    void documentTextsAreCorrectlyAddedTest() {
        documentText.setOrder(order);
        documentText.setId(Id);
        documentTextList.add(documentText);
        when(documentTextRepositoryMock.findAll()).thenReturn(documentTextList);
        CombinedContentList combinedContentList = service.getDocumentContent();

        Combined combined = combinedContentList.getList().get(0);
        assertEquals("text", combined.getContentType());
        assertEquals(order, combined.getOrder());
        assertEquals(Id, combined.getContentId());
    }

    @Test
    void documentImagesAreCorrectlyAddedTest() {
        documentImage.setOrder(order);
        documentImage.setId(Id);
        documentImageList.add(documentImage);
        when(documentImageRepositoryMock.findAll()).thenReturn(documentImageList);
        CombinedContentList combinedContentList = service.getDocumentContent();

        Combined combined = combinedContentList.getList().get(0);
        assertEquals("image", combined.getContentType());
        assertEquals(order, combined.getOrder());
        assertEquals(Id, combined.getContentId());
    }


}