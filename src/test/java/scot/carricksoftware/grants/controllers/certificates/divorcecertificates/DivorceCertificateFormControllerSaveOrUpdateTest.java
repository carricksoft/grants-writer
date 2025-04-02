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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DivorceCertificateFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private DivorceCertificateFormControllerImpl divorceCertificateController;

    @Mock
    private DivorceCertificateService divorceCertificateServiceMock;

    @Mock
    private DivorceCertificateCommandConverterImpl divorceCertificateCommandConverterMock;

    @Mock
    private DivorceCertificateConverterImpl divorceCertificateConverterMock;

    @Mock
    private PersonService personServiceMock;


    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    private DivorceCertificateCommandValidator divorceCertificateCommandValidatorMock;

    private DivorceCertificateCommand divorceCertificateCommand;


    @BeforeEach
    public void setUp() {
        divorceCertificateController = new DivorceCertificateFormControllerImpl(divorceCertificateServiceMock,
                divorceCertificateCommandConverterMock,
                divorceCertificateConverterMock,
                divorceCertificateCommandValidatorMock,
                personServiceMock);
        divorceCertificateCommand = new DivorceCertificateCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        divorceCertificateCommand.setId(id);
        when(divorceCertificateServiceMock.saveDivorceCertificateCommand(any(DivorceCertificateCommand.class))).thenReturn(divorceCertificateCommand);
        assertEquals("redirect:/divorceCertificate/4/show", divorceCertificateController.saveOrUpdate(divorceCertificateCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        divorceCertificateCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("certificates/divorceCertificate/form", divorceCertificateController.saveOrUpdate(divorceCertificateCommand, bindingResultMock, modelMock));
    }

}