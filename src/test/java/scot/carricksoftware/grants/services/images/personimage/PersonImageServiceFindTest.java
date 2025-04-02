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
import scot.carricksoftware.grants.converters.images.personimage.PersonImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.repositories.images.PersonImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPersonImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class PersonImageServiceFindTest {

    PersonImageService personImageService;

    @Mock
    PersonImageRepository personImageRepositoryMock;

    @Mock
    PersonImageConverterImpl personImageConverterMock;

    @Mock
    PersonImageCommandConverterImpl personImageCommandConverterMock;

    @BeforeEach
    public void setUp() {
        personImageService = new PersonImageServiceImpl(personImageRepositoryMock,
                personImageConverterMock,
                personImageCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<PersonImage> countries = new ArrayList<>();
        countries.add(GetRandomPersonImage());
        when(personImageRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, personImageService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        PersonImage personImage = GetRandomPersonImage();
        Optional<PersonImage> personImageOptional = Optional.of(personImage);
        when(personImageRepositoryMock.findById(id)).thenReturn(personImageOptional);
        assertEquals(personImage, personImageService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<PersonImage> empty = Optional.empty();
        when(personImageRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(personImageService.findById(id));
    }

}