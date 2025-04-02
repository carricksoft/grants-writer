/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.services.census.CensusService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class CensusListControllerTest {

    private CensusListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Census> censusListMock;

    @BeforeEach
    public void setUp() {
        controller = new CensusListControllerImpl(controllerHelperMock, censusServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(censusServiceMock.getPagedCensuses(0)).thenReturn(censusListMock);
        assertEquals("census/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("censuses", censusListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(censusServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("census/list", controller.getLastPage(modelMock));
        verify(censusServiceMock, times(2)).getPagedCensuses(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/censuses", controller.censusDelete(Long.toString(id)));
        verify(censusServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<Census> censusList = new ArrayList<>();
        censusList.add(GetRandomCensus());
        when(censusServiceMock.getPagedCensuses(0)).thenReturn(censusList);

        assertEquals("census/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("censuses", censusList);
    }

    @Test
    public void getNextPlaceTest() {
        List<Census> censusList = new ArrayList<>();
        censusList.add(GetRandomCensus());
        when(censusServiceMock.getPagedCensuses(0)).thenReturn(censusList);

        controller.getFirstPage(modelMock);
        assertEquals("census/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("censuses", censusList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<Census> censusList = new ArrayList<>();
        censusList.add(GetRandomCensus());
        when(censusServiceMock.getPagedCensuses(0)).thenReturn(censusList);

        controller.getFirstPage(modelMock);
        assertEquals("census/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("censuses", censusList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(censusServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("census/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
