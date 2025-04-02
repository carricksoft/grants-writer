/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.divorcecertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.divorcecertificates.DivorceCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.divorcecertificates.DivorceCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.DivorceCertificateCommandValidator;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DivorceCertificateFormControllerValidationTest {

    @SuppressWarnings("unused")
    private DivorceCertificateFormControllerImpl divorceCertificateController;

    @Mock
    private DivorceCertificateService divorceCertificateServiceMock;

    @Mock
    private DivorceCertificateCommandConverterImpl divorceCertificateCommandConverterMock;

    @Mock
    private DivorceCertificateConverterImpl divorceCertificateConverterMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private DivorceCertificateCommandValidator divorceCertificateCommandValidatorMock;

    @Mock
    private Model modelMock;


    @BeforeEach
    public void setUp() {
        divorceCertificateController = new DivorceCertificateFormControllerImpl(divorceCertificateServiceMock,
                divorceCertificateCommandConverterMock,
                divorceCertificateConverterMock,
                divorceCertificateCommandValidatorMock,
                personServiceMock);
    }


    @Test
    public void saveOrUpdateValidationTest() {
        DivorceCertificateCommand divorceCertificateCommand = new DivorceCertificateCommandImpl();
        divorceCertificateCommand.setId(GetRandomLong());
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(divorceCertificateServiceMock.saveDivorceCertificateCommand(divorceCertificateCommand)).thenReturn(divorceCertificateCommand);

        divorceCertificateController.saveOrUpdate(divorceCertificateCommand, bindingResultMock, modelMock);

        verify(divorceCertificateCommandValidatorMock).validate(divorceCertificateCommand, bindingResultMock);
    }


}