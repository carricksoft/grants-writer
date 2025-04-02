/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.birthcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.BirthCertificateCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificate;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomBirthCertificateCommand;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class BirthCertificateFormControllerTest {

    @SuppressWarnings("unused")
    private BirthCertificateFormControllerImpl birthCertificateFormController;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private BirthCertificateCommandConverterImpl birthCertificateCommandConverterMock;

    @Mock
    private BirthCertificateConverterImpl birthCertificateConverterMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    private BirthCertificateCommandValidator birthCertificateCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        birthCertificateFormController = new BirthCertificateFormControllerImpl(birthCertificateServiceMock,
                birthCertificateCommandConverterMock,
                birthCertificateConverterMock,
                birthCertificateCommandValidatorMock,
                personServiceMock);
    }

    @Test
    public void getNewBirthCertificateTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("certificates/birthCertificate/form", birthCertificateFormController.getNewBirthCertificate(modelMock));
        verify(modelMock, atLeast(1)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        boolean foundBirthCertificateCommand = false;
        boolean foundPeople = false;
        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("birthCertificateCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("BirthCertificateCommandImpl")) {
                    foundBirthCertificateCommand = true;
                }
            }
            if (stringCaptor.getAllValues().get(i).equals("people")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                    foundPeople = true;
                }
            }
        }

        assertTrue(foundBirthCertificateCommand && foundPeople);

    }

    @Test
    public void birthCertificateEditTestEditTest() {
        Long id = GetRandomLong();
        BirthCertificate birthCertificate = GetRandomBirthCertificate();
        when(birthCertificateServiceMock.findById(id)).thenReturn(birthCertificate);

        assertEquals("certificates/birthCertificate/form", birthCertificateFormController.birthCertificateEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.BIRTH_CERTIFICATE_COMMAND, birthCertificate);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        BirthCertificate birthCertificate = GetRandomBirthCertificate();
        BirthCertificateCommand birthCertificateCommand = GetRandomBirthCertificateCommand();

        when(birthCertificateServiceMock.findById(id)).thenReturn(birthCertificate);
        when(birthCertificateConverterMock.convert(birthCertificate)).thenReturn(birthCertificateCommand);
        assertEquals("certificates/birthCertificate/form", birthCertificateFormController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.BIRTH_CERTIFICATE_COMMAND, birthCertificateCommand);
    }

}