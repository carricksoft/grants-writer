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
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.domains.images.DocumentImage;
import scot.carricksoftware.grantswriter.domains.text.DocumentText;
import scot.carricksoftware.grantswriter.repositories.images.DocumentImageRepository;
import scot.carricksoftware.grantswriter.repositories.text.DocumentTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
class CombinedDocumentServiceSortTest {

    private CombinedDocumentService service;

    @Mock
    DocumentTextRepository documentTextRepositoryMock;

    @Mock
    DocumentImageRepository documentImageRepositoryMock;

    private List<DocumentText> documentTextList;
    private List<DocumentImage> documentImageList;
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
    void sortingWorksTest() {
        String highOrder = "99";
        documentText.setOrder(highOrder);
        documentText.setId(Id);
        documentTextList.add(documentText);
        when(documentTextRepositoryMock.findAll()).thenReturn(documentTextList);

        String lowOrder = "1";
        documentImage.setOrder(lowOrder);
        documentImage.setId(Id);
        documentImageList.add(documentImage);
        when(documentImageRepositoryMock.findAll()).thenReturn(documentImageList);
        CombinedContentList combinedContentList = service.getDocumentContent();

        assertEquals(lowOrder, combinedContentList.getList().get(0).getOrder());
        assertEquals(highOrder, combinedContentList.getList().get(1).getOrder());
    }


}