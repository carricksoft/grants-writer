/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.birthcertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.certificates.BirthCertificateCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BirthCertificateFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private BirthCertificateFormControllerImpl birthCertificateController;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;

    @Mock
    private BirthCertificateCommandConverterImpl birthCertificateCommandConverterMock;

    @Mock
    private BirthCertificateConverterImpl birthCertificateConverterMock;

    @Mock
    private PersonService personServiceMock;


    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    private BirthCertificateCommandValidator birthCertificateCommandValidatorMock;

    private BirthCertificateCommand birthCertificateCommand;


    @BeforeEach
    public void setUp() {
        birthCertificateController = new BirthCertificateFormControllerImpl(birthCertificateServiceMock,
                birthCertificateCommandConverterMock,
                birthCertificateConverterMock,
                birthCertificateCommandValidatorMock,
                personServiceMock);
        birthCertificateCommand = new BirthCertificateCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        birthCertificateCommand.setId(id);
        when(birthCertificateServiceMock.saveBirthCertificateCommand(any(BirthCertificateCommand.class))).thenReturn(birthCertificateCommand);
        assertEquals("redirect:/birthCertificate/4/show", birthCertificateController.saveOrUpdate(birthCertificateCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        birthCertificateCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("certificates/birthCertificate/form", birthCertificateController.saveOrUpdate(birthCertificateCommand, bindingResultMock, modelMock));
    }

}