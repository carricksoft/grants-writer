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
import scot.carricksoftware.grants.commands.places.regions.RegionCommandImpl;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.services.places.countries.CountryService;
import scot.carricksoftware.grants.services.places.regions.RegionService;
import scot.carricksoftware.grants.validators.places.RegionCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RegionFormControllerSaveOrUpdateTest {

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
    private Capitalisation capitalisationMock;

    @Mock
    private Model modelMock;


    @Mock
    BindingResult bindingResultMock;

    @Mock
    RegionCommandValidator regionCommandValidatorMock;

    private RegionCommand regionCommand;


    @BeforeEach
    public void setUp() {
        regionController = new RegionFormControllerImpl(regionServiceMock,
                regionCommandConverterMock,
                regionConverterMock,
                capitalisationMock,
                regionCommandValidatorMock,
                countryServiceMock);
        regionCommand = new RegionCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        regionCommand.setId(id);
        when(regionServiceMock.saveRegionCommand(any(RegionCommand.class))).thenReturn(regionCommand);
        assertEquals("redirect:/region/4/show", regionController.saveOrUpdate(regionCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        regionCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("region/form", regionController.saveOrUpdate(regionCommand, bindingResultMock, modelMock));
    }

    @Test
    public void CleaningTakesPlaceTest() {
        RegionCommand regionCommand = new RegionCommandImpl();
        regionCommand.setId(4L);
        regionCommand.setName("england");
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(regionServiceMock.saveRegionCommand(any(RegionCommand.class))).thenReturn(regionCommand);
        regionController.saveOrUpdate(regionCommand, bindingResultMock, modelMock);
        verify(capitalisationMock).getCapitalisation("england");
    }


}