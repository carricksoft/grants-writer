/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.personimages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.controllers.images.personImages.PersonImageListControllerImpl;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.services.images.personimage.PersonImageService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPersonImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class PersonImageListControllerTest {

    private PersonImageListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private PersonImageService personImageServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<PersonImage> personImageListMock;

    @BeforeEach
    public void setUp() {
        controller = new PersonImageListControllerImpl(controllerHelperMock, personImageServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(personImageServiceMock.getPagedPersonImages(0)).thenReturn(personImageListMock);
        assertEquals("images/personImage/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("personImages", personImageListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(personImageServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("images/personImage/list", controller.getLastPage(modelMock));
        verify(personImageServiceMock, times(2)).getPagedPersonImages(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/personImages", controller.personImageDelete(Long.toString(id)));
        verify(personImageServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<PersonImage> personImageList = new ArrayList<>();
        personImageList.add(GetRandomPersonImage());
        when(personImageServiceMock.getPagedPersonImages(0)).thenReturn(personImageList);

        assertEquals("images/personImage/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("personImages", personImageList);
    }

    @Test
    public void getNextPlaceTest() {
        List<PersonImage> personImageList = new ArrayList<>();
        personImageList.add(GetRandomPersonImage());
        when(personImageServiceMock.getPagedPersonImages(0)).thenReturn(personImageList);

        controller.getFirstPage(modelMock);
        assertEquals("images/personImage/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("personImages", personImageList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<PersonImage> personImageList = new ArrayList<>();
        personImageList.add(GetRandomPersonImage());
        when(personImageServiceMock.getPagedPersonImages(0)).thenReturn(personImageList);

        controller.getFirstPage(modelMock);
        assertEquals("images/personImage/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("personImages", personImageList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(personImageServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("images/personImage/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
