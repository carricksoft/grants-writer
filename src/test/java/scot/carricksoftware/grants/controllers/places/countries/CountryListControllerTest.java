/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.services.places.countries.CountryService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomCountry;


@ExtendWith(MockitoExtension.class)
public class CountryListControllerTest {

    private CountryListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private CountryService countryServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Country> countryListMock;

    @BeforeEach
    public void setUp() {
        controller = new CountryListControllerImpl(controllerHelperMock, countryServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(countryServiceMock.getPagedCountries(0)).thenReturn(countryListMock);
        assertEquals("country/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("countries", countryListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(countryServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("country/list", controller.getLastPage(modelMock));
        verify(countryServiceMock, times(2)).getPagedCountries(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/countries", controller.countryDelete(Long.toString(id)));
        verify(countryServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(GetRandomCountry());
        when(countryServiceMock.getPagedCountries(0)).thenReturn(countryList);

        assertEquals("country/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("countries", countryList);
    }

    @Test
    public void getNextPlaceTest() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(GetRandomCountry());
        when(countryServiceMock.getPagedCountries(0)).thenReturn(countryList);

        controller.getFirstPage(modelMock);
        assertEquals("country/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("countries", countryList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(GetRandomCountry());
        when(countryServiceMock.getPagedCountries(0)).thenReturn(countryList);

        controller.getFirstPage(modelMock);
        assertEquals("country/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("countries", countryList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(countryServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("country/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
