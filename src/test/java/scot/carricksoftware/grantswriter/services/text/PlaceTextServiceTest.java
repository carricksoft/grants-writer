/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.text;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.text.PlaceText;
import scot.carricksoftware.grantswriter.repositories.text.PlaceTextRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
class PlaceTextServiceTest {

    private PlaceTextService placeTextService;

    @Mock
    private PlaceTextRepository placeTextRepositoryMock;


    @BeforeEach
    void setUp() {
        placeTextService = new PlaceTextServiceImpl(placeTextRepositoryMock);
    }

    @Test
    void findByIdTest() {
        Long id = GetRandomLong();
        PlaceText placeText = new PlaceText();
        when(placeTextRepositoryMock.findById(id)).thenReturn(placeText);
        assertEquals(placeText, placeTextService.findById(id));
    }

}