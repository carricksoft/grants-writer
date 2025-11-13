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
import scot.carricksoftware.grantswriter.domains.images.AppendixImage;
import scot.carricksoftware.grantswriter.repositories.images.AppendixImageRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
class AppendixImageServiceTest {

    private AppendixImageService appendixImageService;

    @Mock
    private AppendixImageRepository appendixImageRepositoryMock;

    @BeforeEach
    void setUp() {
        appendixImageService = new AppendixImageServiceImpl(appendixImageRepositoryMock);
    }

    @Test
    void findAllTest() {
        List<AppendixImage> appendixImageList = new ArrayList<>();
        appendixImageList.add(new AppendixImage());
        when(appendixImageRepositoryMock.findAll()).thenReturn(appendixImageList);
        assertEquals(appendixImageList, appendixImageService.findAll());
    }

    @Test
    void findByIdTest() {
        Long id = GetRandomLong();
        AppendixImage appendixImage = new AppendixImage();
        when(appendixImageRepositoryMock.findById(id)).thenReturn(appendixImage);
        assertEquals(appendixImage, appendixImageService.findById(id));
    }

}