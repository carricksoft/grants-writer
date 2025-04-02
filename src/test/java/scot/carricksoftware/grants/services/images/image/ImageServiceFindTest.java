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
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.repositories.images.ImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class ImageServiceFindTest {

    ImageService imageService;

    @Mock
    ImageRepository imageRepositoryMock;

    @Mock
    ImageConverterImpl imageConverterMock;

    @Mock
    ImageCommandConverterImpl imageCommandConverterMock;

    @BeforeEach
    public void setUp() {
        imageService = new ImageServiceImpl(imageRepositoryMock,
                imageConverterMock,
                imageCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<Image> countries = new ArrayList<>();
        countries.add(GetRandomImage());
        when(imageRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, imageService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        Image image = GetRandomImage();
        Optional<Image> imageOptional = Optional.of(image);
        when(imageRepositoryMock.findById(id)).thenReturn(imageOptional);
        assertEquals(image, imageService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<Image> empty = Optional.empty();
        when(imageRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(imageService.findById(id));
    }

}