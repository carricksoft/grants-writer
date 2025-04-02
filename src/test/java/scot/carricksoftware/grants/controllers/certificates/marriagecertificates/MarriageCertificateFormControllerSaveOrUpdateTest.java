/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.marriagecertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.MarriageCertificateCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MarriageCertificateFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private MarriageCertificateFormControllerImpl marriageCertificateController;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;

    @Mock
    private MarriageCertificateCommandConverterImpl marriageCertificateCommandConverterMock;

    @Mock
    private MarriageCertificateConverterImpl marriageCertificateConverterMock;

    @Mock
    private PersonService personServiceMock;


    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    private MarriageCertificateCommandValidator marriageCertificateCommandValidatorMock;

    private MarriageCertificateCommand marriageCertificateCommand;


    @BeforeEach
    public void setUp() {
        marriageCertificateController = new MarriageCertificateFormControllerImpl(marriageCertificateServiceMock,
                marriageCertificateCommandConverterMock,
                marriageCertificateConverterMock,
                marriageCertificateCommandValidatorMock,
                personServiceMock);
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        marriageCertificateCommand.setId(id);
        when(marriageCertificateServiceMock.saveMarriageCertificateCommand(any(MarriageCertificateCommand.class))).thenReturn(marriageCertificateCommand);
        assertEquals("redirect:/marriageCertificate/4/show", marriageCertificateController.saveOrUpdate(marriageCertificateCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        marriageCertificateCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("certificates/marriageCertificate/form", marriageCertificateController.saveOrUpdate(marriageCertificateCommand, bindingResultMock, modelMock));
    }

}