/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.placetext;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextConverterImpl;
import scot.carricksoftware.grants.domains.text.PlaceText;
import scot.carricksoftware.grants.repositories.text.PlaceTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPlaceText;


@ExtendWith(MockitoExtension.class)
public class PlaceTextServiceTest {

    PlaceTextService placeTextService;

    @Mock
    PlaceTextRepository placeTextRepositoryMock;

    @Mock
    PlaceTextConverterImpl placeTextConverterImplMock;

    @Mock
    PlaceTextCommandConverterImpl placeTextCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        placeTextService = new PlaceTextServiceImpl(placeTextRepositoryMock,
                placeTextConverterImplMock,
                placeTextCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<PlaceText> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        placeTextService.deleteById(id);
        verify(placeTextRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(placeTextRepositoryMock.count()).thenReturn(result);
        assertEquals(result, placeTextService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<PlaceText> result = new ArrayList<>();
        PlaceText placeText = GetRandomPlaceText();
        result.add(placeText);
        when(pageMock.getContent()).thenReturn(result);
        when(placeTextRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, placeTextService.getPagedPlaceTexts(0));
    }
    

}