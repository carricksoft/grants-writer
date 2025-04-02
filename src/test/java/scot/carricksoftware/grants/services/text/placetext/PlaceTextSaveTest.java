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
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.commands.text.PlaceTextCommandImpl;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextConverterImpl;
import scot.carricksoftware.grants.domains.text.PlaceText;
import scot.carricksoftware.grants.repositories.text.PlaceTextRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPlaceText;


@ExtendWith(MockitoExtension.class)
public class PlaceTextSaveTest {

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


    @Test
    public void saveTest() {
        PlaceText placeText = new PlaceText();

        when(placeTextRepositoryMock.save(placeText)).thenReturn(placeText);

        assertEquals(placeText, placeTextService.save(placeText));
    }

    @Test
    public void savePlaceTextCommandTest() {
        PlaceText placeText = GetRandomPlaceText();
        PlaceTextCommand placeTextCommand = new PlaceTextCommandImpl();
        when(placeTextCommandConverterImplMock.convert(placeTextCommand)).thenReturn(placeText);
        when(placeTextRepositoryMock.save(placeText)).thenReturn(placeText);
        when(placeTextConverterImplMock.convert((placeText))).thenReturn(placeTextCommand);

        assertEquals(placeTextCommand, placeTextService.savePlaceTextCommand(placeTextCommand));
    }


}