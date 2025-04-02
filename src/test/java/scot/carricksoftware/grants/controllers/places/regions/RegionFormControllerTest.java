/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.services.places.countries.CountryService;
import scot.carricksoftware.grants.services.places.regions.RegionService;
import scot.carricksoftware.grants.validators.places.RegionCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.*;


@ExtendWith(MockitoExtension.class)
public class RegionFormControllerTest {

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
    RegionCommandValidator regionCommandValidatorMock;


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
    public void getNewRegionTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("region/form", regionController.getNewRegion(modelMock));
        verify(modelMock, atLeast(1)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        boolean foundRegionCommand = false;
        boolean foundCountries = false;
        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("regionCommand")
                    &&
                    objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("RegionCommandImpl")) {
                foundRegionCommand = true;
            } else if (stringCaptor.getAllValues().get(i).equals("countries")
                    &&
                    objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                foundCountries = true;
            }
        }
        assertTrue(foundRegionCommand && foundCountries);
    }

    @Test
    public void regionEditTestEditTest() {
        Long id = GetRandomLong();
        Region region = GetRandomRegion();
        when(regionServiceMock.findById(id)).thenReturn(region);

        assertEquals("region/form", regionController.regionEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.REGION_COMMAND, region);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        Region region = GetRandomRegion();
        RegionCommand regionCommand = GetRandomRegionCommand();

        when(regionServiceMock.findById(id)).thenReturn(region);
        when(regionConverterMock.convert(region)).thenReturn(regionCommand);
        assertEquals("region/form", regionController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.REGION_COMMAND, regionCommand);
    }

}