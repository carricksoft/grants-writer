/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.censusentry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.services.census.CensusEntryService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class CensusEntryListControllerTest {

    private CensusEntryListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private CensusEntryService censusEntryServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<CensusEntry> censusEntryListMock;

    @BeforeEach
    public void setUp() {
        controller = new CensusEntryListControllerImpl(controllerHelperMock, censusEntryServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(censusEntryServiceMock.getPagedCensusEntries(0)).thenReturn(censusEntryListMock);
        assertEquals("censusentry/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("censusEntries", censusEntryListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(censusEntryServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("censusentry/list", controller.getLastPage(modelMock));
        verify(censusEntryServiceMock, times(2)).getPagedCensusEntries(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/censusEntries", controller.censusEntryDelete(Long.toString(id)));
        verify(censusEntryServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<CensusEntry> censusEntryList = new ArrayList<>();
        censusEntryList.add(GetRandomCensusEntry());
        when(censusEntryServiceMock.getPagedCensusEntries(0)).thenReturn(censusEntryList);

        assertEquals("censusentry/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("censusEntries", censusEntryList);
    }

    @Test
    public void getNextPlaceTest() {
        List<CensusEntry> censusEntryList = new ArrayList<>();
        censusEntryList.add(GetRandomCensusEntry());
        when(censusEntryServiceMock.getPagedCensusEntries(0)).thenReturn(censusEntryList);

        controller.getFirstPage(modelMock);
        assertEquals("censusentry/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("censusEntries", censusEntryList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<CensusEntry> censusEntryList = new ArrayList<>();
        censusEntryList.add(GetRandomCensusEntry());
        when(censusEntryServiceMock.getPagedCensusEntries(0)).thenReturn(censusEntryList);

        controller.getFirstPage(modelMock);
        assertEquals("censusentry/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("censusEntries", censusEntryList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(censusEntryServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("censusentry/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
