/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.constants.ImageAttributeConstants;
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.ImageCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomImage;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomImageCommand;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class ImageFormControllerTest {

    @SuppressWarnings("unused")
    private ImageFormControllerImpl imageController;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private ImageCommandConverterImpl imageCommandConverterMock;

    @Mock
    private ImageConverterImpl imageConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private ImageCommandValidator imageCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        imageController = new ImageFormControllerImpl(imageServiceMock,
                imageCommandConverterMock,
                imageConverterMock,
                imageCommandValidatorMock);
    }

    @Test
    public void getNewImageTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("images/image/form", imageController.getNewImage(modelMock));
        verify(modelMock).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertEquals("imageCommand", stringCaptor.getValue());
        assertEquals("ImageCommandImpl", objectCaptor.getValue().getClass().getSimpleName());
    }

    @Test
    public void imageEditTestEditTest() {
        Long id = GetRandomLong();
        Image image = GetRandomImage();
        when(imageServiceMock.findById(id)).thenReturn(image);

        assertEquals("images/image/form", imageController.imageEdit(id + "", modelMock));
        verify(modelMock).addAttribute(ImageAttributeConstants.IMAGE_COMMAND, image);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        Image image = GetRandomImage();
        ImageCommand imageCommand = GetRandomImageCommand();

        when(imageServiceMock.findById(id)).thenReturn(image);
        when(imageConverterMock.convert(image)).thenReturn(imageCommand);
        assertEquals("images/image/form", imageController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(ImageAttributeConstants.IMAGE_COMMAND, imageCommand);
    }

}