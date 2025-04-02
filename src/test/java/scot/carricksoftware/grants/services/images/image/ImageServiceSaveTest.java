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
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.commands.images.ImageCommandImpl;
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.repositories.images.ImageRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomImage;


@ExtendWith(MockitoExtension.class)
public class ImageServiceSaveTest {

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


    @Test
    public void saveTest() {
        Image image = new Image();

        when(imageRepositoryMock.save(image)).thenReturn(image);

        assertEquals(image, imageService.save(image));
    }

    @Test
    public void saveImageCommandTest() {
        Image image = GetRandomImage();
        ImageCommand imageCommand = new ImageCommandImpl();
        when(imageCommandConverterImplMock.convert(imageCommand)).thenReturn(image);
        when(imageRepositoryMock.save(image)).thenReturn(image);
        when(imageConverterImplMock.convert((image))).thenReturn(imageCommand);

        assertEquals(imageCommand, imageService.saveImageCommand(imageCommand));
    }


}