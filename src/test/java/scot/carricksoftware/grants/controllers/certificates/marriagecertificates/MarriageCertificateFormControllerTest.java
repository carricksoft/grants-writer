/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.marriagecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.MarriageCertificateCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class MarriageCertificateFormControllerTest {

    @SuppressWarnings("unused")
    private MarriageCertificateFormControllerImpl marriageCertificateFormController;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;

    @Mock
    private MarriageCertificateCommandConverterImpl marriageCertificateCommandConverterMock;

    @Mock
    private MarriageCertificateConverterImpl marriageCertificateConverterMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    private MarriageCertificateCommandValidator marriageCertificateCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        marriageCertificateFormController = new MarriageCertificateFormControllerImpl(marriageCertificateServiceMock,
                marriageCertificateCommandConverterMock,
                marriageCertificateConverterMock,
                marriageCertificateCommandValidatorMock,
                personServiceMock);
    }

    @Test
    public void getNewMarriageCertificateTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("certificates/marriageCertificate/form", marriageCertificateFormController.getNewMarriageCertificate(modelMock));
        verify(modelMock, atLeast(1)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        boolean foundMarriageCertificateCommand = false;
        boolean foundPeople = false;
        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("marriageCertificateCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("MarriageCertificateCommandImpl")) {
                    foundMarriageCertificateCommand = true;
                }
            }
            if (stringCaptor.getAllValues().get(i).equals("people")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                    foundPeople = true;
                }
            }
        }

        assertTrue(foundMarriageCertificateCommand && foundPeople);

    }

    @Test
    public void marriageCertificateEditTestEditTest() {
        Long id = GetRandomLong();
        MarriageCertificate marriageCertificate = GetRandomMarriageCertificate();
        when(marriageCertificateServiceMock.findById(id)).thenReturn(marriageCertificate);

        assertEquals("certificates/marriageCertificate/form", marriageCertificateFormController.marriageCertificateEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, marriageCertificate);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        MarriageCertificate marriageCertificate = GetRandomMarriageCertificate();
        MarriageCertificateCommand marriageCertificateCommand = GetRandomMarriageCertificateCommand();

        when(marriageCertificateServiceMock.findById(id)).thenReturn(marriageCertificate);
        when(marriageCertificateConverterMock.convert(marriageCertificate)).thenReturn(marriageCertificateCommand);
        assertEquals("certificates/marriageCertificate/form", marriageCertificateFormController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, marriageCertificateCommand);
    }

}