/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.deathcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.DeathCertificateCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DeathCertificateFormControllerTest {

    @SuppressWarnings("unused")
    private DeathCertificateFormControllerImpl deathCertificateFormController;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    @Mock
    private DeathCertificateCommandConverterImpl deathCertificateCommandConverterMock;

    @Mock
    private DeathCertificateConverterImpl deathCertificateConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private DeathCertificateCommandValidator deathCertificateCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        deathCertificateFormController = new DeathCertificateFormControllerImpl(deathCertificateServiceMock,
                deathCertificateCommandConverterMock,
                deathCertificateConverterMock,
                deathCertificateCommandValidatorMock,
                personServiceMock);
    }

    @Test
    public void getNewDeathCertificateTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("certificates/deathCertificate/form", deathCertificateFormController.getNewDeathCertificate(modelMock));
        verify(modelMock, atLeast(1)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        boolean foundDeathCertificateCommand = false;
        boolean foundPeople = false;
        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("deathCertificateCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("DeathCertificateCommandImpl")) {
                    foundDeathCertificateCommand = true;
                }
            }
            if (stringCaptor.getAllValues().get(i).equals("people")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                    foundPeople = true;
                }
            }
        }
        assertTrue(foundDeathCertificateCommand && foundPeople);
    }

    @Test
    public void deathCertificateEditTestEditTest() {
        Long id = GetRandomLong();
        DeathCertificate deathCertificate = GetRandomDeathCertificate();
        when(deathCertificateServiceMock.findById(id)).thenReturn(deathCertificate);

        assertEquals("certificates/deathCertificate/form", deathCertificateFormController.deathCertificateEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.DEATH_CERTIFICATE_COMMAND, deathCertificate);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        DeathCertificate deathCertificate = GetRandomDeathCertificate();
        DeathCertificateCommand deathCertificateCommand = GetRandomDeathCertificateCommand();

        when(deathCertificateServiceMock.findById(id)).thenReturn(deathCertificate);
        when(deathCertificateConverterMock.convert(deathCertificate)).thenReturn(deathCertificateCommand);
        assertEquals("certificates/deathCertificate/form", deathCertificateFormController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.DEATH_CERTIFICATE_COMMAND, deathCertificateCommand);
    }

}