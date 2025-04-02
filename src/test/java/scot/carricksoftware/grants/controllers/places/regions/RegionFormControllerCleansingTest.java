/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.services.places.countries.CountryService;
import scot.carricksoftware.grants.services.places.regions.RegionService;
import scot.carricksoftware.grants.validators.places.RegionCommandValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RegionFormControllerCleansingTest {

    @SuppressWarnings("unused")
    private RegionFormControllerImpl regionController;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private CountryService countryServiceMock;


    @Mock
    private RegionCommandConverterImpl regionCommandConverterMock;

    @Mock
    private RegionConverterImpl regionConverterMock;


    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    RegionCommand regionCommandMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    RegionCommandValidator regionCommandValidatorMock;

    @Mock
    Model modelMock;


    @BeforeEach
    public void setUp() {
        regionController = new RegionFormControllerImpl(regionServiceMock,
                regionCommandConverterMock,
                regionConverterMock,
                capitalisationMock,
                regionCommandValidatorMock,
                countryServiceMock);
    }


    @Test
    public void saveOrUpdateCleansingTest() {
        String name = "goat";
        String uName = "Goat";
        when(regionServiceMock.saveRegionCommand(any())).thenReturn(regionCommandMock);
        when(regionCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        regionController.saveOrUpdate(regionCommandMock, bindingResultMock, modelMock);
        verify(regionCommandMock).setName(uName);
    }

    @Test
    public void saveOrUpdateValidationTest() {
        String name = "goat";
        String uName = "Goat";
        when(regionServiceMock.saveRegionCommand(any())).thenReturn(regionCommandMock);
        when(regionCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        regionController.saveOrUpdate(regionCommandMock, bindingResultMock, modelMock);
        verify(regionCommandValidatorMock).validate(regionCommandMock, bindingResultMock);
    }


}