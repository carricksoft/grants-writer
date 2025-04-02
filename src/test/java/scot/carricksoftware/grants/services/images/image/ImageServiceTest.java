/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.image;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.repositories.images.ImageRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class ImageServiceTest {

    ImageService imageService;

    @Mock
    ImageRepository imageRepositoryMock;

    @Mock
    ImageConverterImpl imageConverterImplMock;

    @Mock
    ImageCommandConverterImpl imageCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        imageService = new ImageServiceImpl(imageRepositoryMock,
                imageConverterImplMock,
                imageCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<Image> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        imageService.deleteById(id);
        verify(imageRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(imageRepositoryMock.count()).thenReturn(result);
        assertEquals(result, imageService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<Image> result = new ArrayList<>();
        Image image = GetRandomImage();
        result.add(image);
        when(pageMock.getContent()).thenReturn(result);
        when(imageRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, imageService.getPagedImages(0));
    }




}