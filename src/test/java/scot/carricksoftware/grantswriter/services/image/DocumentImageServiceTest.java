/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.images.DocumentImage;
import scot.carricksoftware.grantswriter.repositories.images.DocumentImageRepository;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
class DocumentImageServiceTest {

    private DocumentImageService documentImageService;

    @Mock
    private DocumentImageRepository documentImageRepositoryMock;

    @BeforeEach
    void setUp() {
        documentImageService = new DocumentImageServiceImpl(documentImageRepositoryMock);
    }

    @Test
    void findAllTest() {
        List<DocumentImage> documentImageList = new ArrayList<>();
        documentImageList.add(new DocumentImage());
        when(documentImageRepositoryMock.findAll()).thenReturn(documentImageList);
        assertEquals(documentImageList, documentImageService.findAll());
    }

    @Test
    void findByIdTest() {
        Long id = GetRandomLong();
        DocumentImage documentImage = new DocumentImage();
        when(documentImageRepositoryMock.findById(id)).thenReturn(documentImage);
        assertEquals(documentImage, documentImageService.findById(id));
    }

}