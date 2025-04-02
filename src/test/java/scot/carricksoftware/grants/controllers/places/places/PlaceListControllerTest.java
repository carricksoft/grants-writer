/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.places.places.PlaceService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


@ExtendWith(MockitoExtension.class)
public class PlaceListControllerTest {

    private PLaceListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Place> placeListMock;

    @BeforeEach
    public void setUp() {
        controller = new PLaceListControllerImpl(controllerHelperMock, placeServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(placeServiceMock.getPagedPlaces(0)).thenReturn(placeListMock);
        assertEquals("place/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("places", placeListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(placeServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("place/list", controller.getLastPage(modelMock));
        verify(placeServiceMock, times(2)).getPagedPlaces(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/countries", controller.placeDelete(Long.toString(id)));
        verify(placeServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<Place> placeList = new ArrayList<>();
        placeList.add(GetRandomPlace());
        when(placeServiceMock.getPagedPlaces(0)).thenReturn(placeList);

        assertEquals("place/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("places", placeList);
    }

    @Test
    public void getNextPlaceTest() {
        List<Place> placeList = new ArrayList<>();
        placeList.add(GetRandomPlace());
        when(placeServiceMock.getPagedPlaces(0)).thenReturn(placeList);

        controller.getFirstPage(modelMock);
        assertEquals("place/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("places", placeList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<Place> placeList = new ArrayList<>();
        placeList.add(GetRandomPlace());
        when(placeServiceMock.getPagedPlaces(0)).thenReturn(placeList);

        controller.getFirstPage(modelMock);
        assertEquals("place/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("places", placeList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(placeServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("place/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
