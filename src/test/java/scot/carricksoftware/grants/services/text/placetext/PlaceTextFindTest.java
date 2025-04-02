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
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextConverterImpl;
import scot.carricksoftware.grants.domains.text.PlaceText;
import scot.carricksoftware.grants.repositories.text.PlaceTextRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPlaceText;

@ExtendWith(MockitoExtension.class)
public class PlaceTextFindTest {

    PlaceTextService placeTextService;

    @Mock
    PlaceTextRepository placeTextRepositoryMock;

    @Mock
    PlaceTextConverterImpl placeTextConverterMock;

    @Mock
    PlaceTextCommandConverterImpl placeTextCommandConverterMock;

    @BeforeEach
    public void setUp() {
        placeTextService = new PlaceTextServiceImpl(placeTextRepositoryMock,
                placeTextConverterMock,
                placeTextCommandConverterMock);
    }

    @Test
    public void FindAllTest() {
        List<PlaceText> countries = new ArrayList<>();
        countries.add(GetRandomPlaceText());
        when(placeTextRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, placeTextService.findAll());
    }

    @Test
    public void findByFoundIdTest() {
        Long id = GetRandomLong();
        PlaceText placeText = GetRandomPlaceText();
        Optional<PlaceText> placeTextOptional = Optional.of(placeText);
        when(placeTextRepositoryMock.findById(id)).thenReturn(placeTextOptional);
        assertEquals(placeText, placeTextService.findById(id));
    }

    @Test
    public void findByNotFoundIdTest() {
        Long id = GetRandomLong();
        Optional<PlaceText> empty = Optional.empty();
        when(placeTextRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(placeTextService.findById(id));
    }

}