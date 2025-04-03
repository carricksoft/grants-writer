/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 14:31. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.text;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.commands.text.PlaceTextCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PlaceTextCommandValidatorTest {

    private PlaceTextCommandValidator validator;

    private PlaceTextCommand placeTextCommand;

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new PlaceTextCommandValidator();
        placeTextCommand = new PlaceTextCommandImpl();

        stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor2 = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor3 = ArgumentCaptor.forClass(String.class);
        objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);
    }

    @Test
    void validateNullPlaceTest() {
        validator.validate(placeTextCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("place", stringArgumentCaptor.getValue());
        assertEquals("The place cannot be null.", stringArgumentCaptor3.getValue());
    }
}