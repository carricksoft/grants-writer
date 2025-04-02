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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class MarriageCertificateFormControllerValidationTest {

    @SuppressWarnings("unused")
    private MarriageCertificateFormControllerImpl marriageCertificateController;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;

    @Mock
    private MarriageCertificateCommandConverterImpl marriageCertificateCommandConverterMock;

    @Mock
    private MarriageCertificateConverterImpl marriageCertificateConverterMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private MarriageCertificateCommandValidator marriageCertificateCommandValidatorMock;

    @Mock
    private Model modelMock;


    @BeforeEach
    public void setUp() {
        marriageCertificateController = new MarriageCertificateFormControllerImpl(marriageCertificateServiceMock,
                marriageCertificateCommandConverterMock,
                marriageCertificateConverterMock,
                marriageCertificateCommandValidatorMock,
                personServiceMock);
    }


    @Test
    public void saveOrUpdateValidationTest() {
        MarriageCertificateCommand marriageCertificateCommand = new MarriageCertificateCommandImpl();
        marriageCertificateCommand.setId(GetRandomLong());
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(marriageCertificateServiceMock.saveMarriageCertificateCommand(marriageCertificateCommand)).thenReturn(marriageCertificateCommand);

        marriageCertificateController.saveOrUpdate(marriageCertificateCommand, bindingResultMock, modelMock);

        verify(marriageCertificateCommandValidatorMock).validate(marriageCertificateCommand, bindingResultMock);
    }


}