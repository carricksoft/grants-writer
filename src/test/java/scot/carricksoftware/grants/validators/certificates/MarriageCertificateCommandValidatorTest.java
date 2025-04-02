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
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class MarriageCertificateCommandValidatorTest {

    private MarriageCertificateCommandValidator commandValidator;

    private MarriageCertificateCommand marriageCertificateCommand;

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        commandValidator = new MarriageCertificateCommandValidator();
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor2 = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor3 = ArgumentCaptor.forClass(String.class);
        objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

    }

    @Test
    public void nullBrideTest() {
        marriageCertificateCommand.setGroom(GetRandomPerson());
        runAndCapture();

        assertEquals("bride", stringArgumentCaptor.getValue());
        assertEquals("The bride cannot be null.", stringArgumentCaptor3.getValue());
    }


    @Test
    public void nullGroomTest() {
        marriageCertificateCommand.setBride(GetRandomPerson());
        runAndCapture();

        assertEquals("groom", stringArgumentCaptor.getValue());
        assertEquals("The groom cannot be null.", stringArgumentCaptor3.getValue());
    }

    private void runAndCapture() {
        commandValidator.validate(marriageCertificateCommand, bindingResultMock);
        verify(bindingResultMock, atLeast(1)).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());
    }

    @Test
    public void samePersonTest() {
        Person person = GetRandomPerson();
        marriageCertificateCommand.setBride(person);
        marriageCertificateCommand.setGroom(person);

        runAndCapture();

        boolean foundGroom = false;
        boolean foundBride = false;
        for (int i = 0; i < objectArgumentCaptor.getAllValues().size(); i++) {
            if (stringArgumentCaptor.getAllValues().get(i).equals("groom")) {
                if (stringArgumentCaptor3.getAllValues().get(i).equals("The bride and groom cannot be the same person.")) {
                    foundGroom = true;
                }
            } else {
                if (stringArgumentCaptor.getAllValues().get(i).equals("bride")) {
                    if (stringArgumentCaptor3.getAllValues().get(i).equals("The bride and groom cannot be the same person.")) {
                        foundBride = true;
                    }
                }
            }
        }

        assertTrue(foundGroom && foundBride);
    }


}