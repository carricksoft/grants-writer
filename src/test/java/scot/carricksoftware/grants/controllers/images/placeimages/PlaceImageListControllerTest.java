/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.placeimages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.services.images.placeimage.PlaceImageService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPlaceImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class PlaceImageListControllerTest {

    private PlaceImageListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private PlaceImageService placeImageServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<PlaceImage> placeImageListMock;

    @BeforeEach
    public void setUp() {
        controller = new PlaceImageListControllerImpl(controllerHelperMock, placeImageServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(placeImageServiceMock.getPagedPlaceImages(0)).thenReturn(placeImageListMock);
        assertEquals("images/placeImage/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("placeImages", placeImageListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(placeImageServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("images/placeImage/list", controller.getLastPage(modelMock));
        verify(placeImageServiceMock, times(2)).getPagedPlaceImages(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/placeImages", controller.placeImageDelete(Long.toString(id)));
        verify(placeImageServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<PlaceImage> placeImageList = new ArrayList<>();
        placeImageList.add(GetRandomPlaceImage());
        when(placeImageServiceMock.getPagedPlaceImages(0)).thenReturn(placeImageList);

        assertEquals("images/placeImage/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("placeImages", placeImageList);
    }

    @Test
    public void getNextPlaceTest() {
        List<PlaceImage> placeImageList = new ArrayList<>();
        placeImageList.add(GetRandomPlaceImage());
        when(placeImageServiceMock.getPagedPlaceImages(0)).thenReturn(placeImageList);

        controller.getFirstPage(modelMock);
        assertEquals("images/placeImage/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("placeImages", placeImageList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<PlaceImage> placeImageList = new ArrayList<>();
        placeImageList.add(GetRandomPlaceImage());
        when(placeImageServiceMock.getPagedPlaceImages(0)).thenReturn(placeImageList);

        controller.getFirstPage(modelMock);
        assertEquals("images/placeImage/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("placeImages", placeImageList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(placeImageServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("images/placeImage/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
