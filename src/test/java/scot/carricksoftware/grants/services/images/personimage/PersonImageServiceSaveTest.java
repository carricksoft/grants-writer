/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.personimage;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.commands.images.PersonImageCommandImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.repositories.images.PersonImageRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPersonImage;


@ExtendWith(MockitoExtension.class)
public class PersonImageServiceSaveTest {

    PersonImageService personImageService;

    @Mock
    PersonImageRepository personImageRepositoryMock;

    @Mock
    PersonImageConverterImpl personImageConverterImplMock;

    @Mock
    PersonImageCommandConverterImpl personImageCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        personImageService = new PersonImageServiceImpl(personImageRepositoryMock,
                personImageConverterImplMock,
                personImageCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        PersonImage personImage = new PersonImage();

        when(personImageRepositoryMock.save(personImage)).thenReturn(personImage);

        assertEquals(personImage, personImageService.save(personImage));
    }

    @Test
    public void savePersonImageCommandTest() {
        PersonImage personImage = GetRandomPersonImage();
        PersonImageCommand personImageCommand = new PersonImageCommandImpl();
        when(personImageCommandConverterImplMock.convert(personImageCommand)).thenReturn(personImage);
        when(personImageRepositoryMock.save(personImage)).thenReturn(personImage);
        when(personImageConverterImplMock.convert((personImage))).thenReturn(personImageCommand);

        assertEquals(personImageCommand, personImageService.savePersonImageCommand(personImageCommand));
    }


}