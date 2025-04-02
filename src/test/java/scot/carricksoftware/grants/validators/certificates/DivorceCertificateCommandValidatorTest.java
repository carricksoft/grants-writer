/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 11:37. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class DivorceCertificateCommandValidatorTest {

    private DivorceCertificateCommandValidator commandValidator;

    private DivorceCertificateCommand divorceCertificateCommand;

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        commandValidator = new DivorceCertificateCommandValidator();
        divorceCertificateCommand = new DivorceCertificateCommandImpl();
        stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor2 = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor3 = ArgumentCaptor.forClass(String.class);
        objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

    }

    @Test
    public void nullFirstPartyTest() {
        divorceCertificateCommand.setSecondParty(GetRandomPerson());
        runAndCapture();

        assertEquals("firstParty", stringArgumentCaptor.getValue());
        assertEquals("The first party cannot be null.", stringArgumentCaptor3.getValue());
    }


    @Test
    public void nullSecondPartyTest() {
        divorceCertificateCommand.setFirstParty(GetRandomPerson());
        runAndCapture();

        assertEquals("secondParty", stringArgumentCaptor.getValue());
        assertEquals("The second party cannot be null.", stringArgumentCaptor3.getValue());
    }

    private void runAndCapture() {
        commandValidator.validate(divorceCertificateCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());
    }

    @Test
    public void samePersonTest() {
        Person person = GetRandomPerson();
        divorceCertificateCommand.setFirstParty(person);
        divorceCertificateCommand.setSecondParty(person);

        runAndCapture();

        boolean foundFirstParty = false;
        boolean foundSecondParty = false;
        for (int i = 0; i < objectArgumentCaptor.getAllValues().size(); i++) {
            if (stringArgumentCaptor.getAllValues().get(i).equals("firstParty")) {
                if (stringArgumentCaptor3.getAllValues().get(i).equals("The two parties cannot be the same person.")) {
                    foundFirstParty = true;
                }
            } else {
                if (stringArgumentCaptor.getAllValues().get(i).equals("secondParty")) {
                    if (stringArgumentCaptor3.getAllValues().get(i).equals("The two parties cannot be the same person.")) {
                        foundSecondParty = true;
                    }
                }
            }
        }

        assertTrue(foundFirstParty && foundSecondParty);
    }


}