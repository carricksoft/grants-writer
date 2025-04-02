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
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.services.places.regions.RegionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomRegion;


@ExtendWith(MockitoExtension.class)
public class RegionListControllerTest {

    private RegionListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Region> regionListMock;

    @BeforeEach
    public void setUp() {
        controller = new RegionListControllerImpl(controllerHelperMock, regionServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(regionServiceMock.getPagedRegions(0)).thenReturn(regionListMock);
        assertEquals("region/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("regions", regionListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(regionServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("region/list", controller.getLastPage(modelMock));
        verify(regionServiceMock, times(2)).getPagedRegions(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/regions", controller.regionDelete(Long.toString(id)));
        verify(regionServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<Region> regionList = new ArrayList<>();
        regionList.add(GetRandomRegion());
        when(regionServiceMock.getPagedRegions(0)).thenReturn(regionList);

        assertEquals("region/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("regions", regionList);
    }

    @Test
    public void getNextPlaceTest() {
        List<Region> regionList = new ArrayList<>();
        regionList.add(GetRandomRegion());
        when(regionServiceMock.getPagedRegions(0)).thenReturn(regionList);

        controller.getFirstPage(modelMock);
        assertEquals("region/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("regions", regionList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<Region> regionList = new ArrayList<>();
        regionList.add(GetRandomRegion());
        when(regionServiceMock.getPagedRegions(0)).thenReturn(regionList);

        controller.getFirstPage(modelMock);
        assertEquals("region/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("regions", regionList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(regionServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("region/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
