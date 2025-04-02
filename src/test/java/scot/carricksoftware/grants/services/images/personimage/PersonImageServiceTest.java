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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.repositories.images.PersonImageRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPersonImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class PersonImageServiceTest {

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

    @Mock
    Page<PersonImage> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        personImageService.deleteById(id);
        verify(personImageRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(personImageRepositoryMock.count()).thenReturn(result);
        assertEquals(result, personImageService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<PersonImage> result = new ArrayList<>();
        PersonImage personImage = GetRandomPersonImage();
        result.add(personImage);
        when(pageMock.getContent()).thenReturn(result);
        when(personImageRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, personImageService.getPagedPersonImages(0));
    }




}