/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.placetext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.text.PlaceText;
import scot.carricksoftware.grants.services.text.placetext.PlaceTextService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPlaceText;


@ExtendWith(MockitoExtension.class)
public class PlaceTextListControllerTest {

    private PlaceTextListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private PlaceTextService placeTextServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<PlaceText> placeTextListMock;

    @BeforeEach
    public void setUp() {
        controller = new PlaceTextListControllerImpl(controllerHelperMock, placeTextServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(placeTextServiceMock.getPagedPlaceTexts(0)).thenReturn(placeTextListMock);
        assertEquals("text/placeText/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("placeTexts", placeTextListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(placeTextServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("text/placeText/list", controller.getLastPage(modelMock));
        verify(placeTextServiceMock, times(2)).getPagedPlaceTexts(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/placeTexts", controller.PlaceTextDelete(Long.toString(id)));
        verify(placeTextServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<PlaceText> placeTextList = new ArrayList<>();
        placeTextList.add(GetRandomPlaceText());
        when(placeTextServiceMock.getPagedPlaceTexts(0)).thenReturn(placeTextList);

        assertEquals("text/placeText/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("placeTexts", placeTextList);
    }

    @Test
    public void getNextPlaceTest() {
        List<PlaceText> placeTextList = new ArrayList<>();
        placeTextList.add(GetRandomPlaceText());
        when(placeTextServiceMock.getPagedPlaceTexts(0)).thenReturn(placeTextList);

        controller.getFirstPage(modelMock);
        assertEquals("text/placeText/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("placeTexts", placeTextList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<PlaceText> placeTextList = new ArrayList<>();
        placeTextList.add(GetRandomPlaceText());
        when(placeTextServiceMock.getPagedPlaceTexts(0)).thenReturn(placeTextList);

        controller.getFirstPage(modelMock);
        assertEquals("text/placeText/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("placeTexts", placeTextList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(placeTextServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("text/placeText/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
