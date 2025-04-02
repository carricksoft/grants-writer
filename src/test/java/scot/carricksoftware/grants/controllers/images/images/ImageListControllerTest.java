/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.services.images.image.ImageService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class ImageListControllerTest {

    private ImageListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Image> imageListMock;

    @BeforeEach
    public void setUp() {
        controller = new ImageListControllerImpl(controllerHelperMock, imageServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(imageServiceMock.getPagedImages(0)).thenReturn(imageListMock);
        assertEquals("images/image/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("images", imageListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(imageServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("images/image/list", controller.getLastPage(modelMock));
        verify(imageServiceMock, times(2)).getPagedImages(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/countries", controller.imageDelete(Long.toString(id)));
        verify(imageServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<Image> imageList = new ArrayList<>();
        imageList.add(GetRandomImage());
        when(imageServiceMock.getPagedImages(0)).thenReturn(imageList);

        assertEquals("images/image/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("images", imageList);
    }

    @Test
    public void getNextPlaceTest() {
        List<Image> imageList = new ArrayList<>();
        imageList.add(GetRandomImage());
        when(imageServiceMock.getPagedImages(0)).thenReturn(imageList);

        controller.getFirstPage(modelMock);
        assertEquals("images/image/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("images", imageList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<Image> imageList = new ArrayList<>();
        imageList.add(GetRandomImage());
        when(imageServiceMock.getPagedImages(0)).thenReturn(imageList);

        controller.getFirstPage(modelMock);
        assertEquals("images/image/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("images", imageList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(imageServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("images/image/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
