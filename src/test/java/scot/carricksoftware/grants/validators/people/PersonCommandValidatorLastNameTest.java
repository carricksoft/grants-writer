/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 11:41. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class PersonCommandValidatorLastNameTest {

    private PersonCommandValidator validator;

    private PersonCommand personCommand;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new PersonCommandValidator();
        personCommand = new PersonCommandImpl();
        personCommand.setFirstName("Valid");
    }

    @Test
    public void lastNameMinimumSizeIsAllowedTest() {
        String repeated = new String(new char[ApplicationConstants.MINIMUM_NAME_LENGTH]).replace("\0", "x");
        personCommand.setLastName(repeated);
        validator.validate(personCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void LastNameMaximumSizeIsAllowedTest() {
        String repeated = new String(new char[ApplicationConstants.MAXIMUM_NAME_LENGTH]).replace("\0", "x");
        personCommand.setLastName(repeated);
        validator.validate(personCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void lastNameGreaterThanMaximumSizeIsRejectedTest() {
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Object[]> objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

        String repeated = new String(new char[ApplicationConstants.MAXIMUM_NAME_LENGTH + 1]).replace("\0", "x");
        personCommand.setLastName(repeated);
        validator.validate(personCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor.capture());
        assertEquals("lastName", stringArgumentCaptor.getAllValues().get(0));
        assertEquals(ApplicationConstants.EMPTY_STRING, stringArgumentCaptor.getAllValues().get(1));
        assertEquals(ValidationConstants.NAME_IS_TOO_LONG, stringArgumentCaptor.getAllValues().get(2));
        assertNull(objectArgumentCaptor.getAllValues().get(0));
    }

    @Test
    public void lastNameSmallerThanMinimumSizeIsRejectedTest() {
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Object[]> objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

        String repeated = new String(new char[ApplicationConstants.MINIMUM_NAME_LENGTH - 1]).replace("\0", "x");
        personCommand.setLastName(repeated);
        validator.validate(personCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(), stringArgumentCaptor.capture(), objectArgumentCaptor.capture(), stringArgumentCaptor.capture());
        assertEquals("lastName", stringArgumentCaptor.getAllValues().get(0));
        assertEquals(ApplicationConstants.EMPTY_STRING, stringArgumentCaptor.getAllValues().get(1));
        assertEquals(ValidationConstants.NAME_IS_TOO_SHORT, stringArgumentCaptor.getAllValues().get(2));
        assertNull(objectArgumentCaptor.getAllValues().get(0));
    }
}