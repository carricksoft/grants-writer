/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 14:46. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.divorcecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.services.certificates.divorcecertificates.DivorceCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.DivorceCertificateCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DivorceCertificateFormControllerTest {

    @SuppressWarnings("unused")
    private DivorceCertificateFormControllerImpl divorceCertificateFormController;

    @Mock
    private DivorceCertificateService divorceCertificateServiceMock;

    @Mock
    private DivorceCertificateCommandConverterImpl divorceCertificateCommandConverterMock;

    @Mock
    private DivorceCertificateConverterImpl divorceCertificateConverterMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    private DivorceCertificateCommandValidator divorceCertificateCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        divorceCertificateFormController = new DivorceCertificateFormControllerImpl(divorceCertificateServiceMock,
                divorceCertificateCommandConverterMock,
                divorceCertificateConverterMock,
                divorceCertificateCommandValidatorMock,
                personServiceMock);
    }

    @Test
    public void getNewDivorceCertificateTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("certificates/divorceCertificate/form", divorceCertificateFormController.getNewDivorceCertificate(modelMock));
        verify(modelMock, atLeast(1)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        boolean foundDivorceCertificateCommand = false;
        boolean foundPeople = false;
        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("divorceCertificateCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("DivorceCertificateCommandImpl")) {
                    foundDivorceCertificateCommand = true;
                }
            }
            if (stringCaptor.getAllValues().get(i).equals("people")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                    foundPeople = true;
                }
            }
        }

        assertTrue(foundDivorceCertificateCommand && foundPeople);

    }

    @Test
    public void divorceCertificateEditTestEditTest() {
        Long id = GetRandomLong();
        DivorceCertificate divorceCertificate = GetRandomDivorceCertificate();
        when(divorceCertificateServiceMock.findById(id)).thenReturn(divorceCertificate);

        assertEquals("certificates/divorceCertificate/form", divorceCertificateFormController.divorceCertificateEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.DIVORCE_CERTIFICATE_COMMAND, divorceCertificate);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        DivorceCertificate divorceCertificate = GetRandomDivorceCertificate();
        DivorceCertificateCommand divorceCertificateCommand = GetRandomDivorceCertificateCommand();

        when(divorceCertificateServiceMock.findById(id)).thenReturn(divorceCertificate);
        when(divorceCertificateConverterMock.convert(divorceCertificate)).thenReturn(divorceCertificateCommand);
        assertEquals("certificates/divorceCertificate/form", divorceCertificateFormController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.DIVORCE_CERTIFICATE_COMMAND, divorceCertificateCommand);
    }

}