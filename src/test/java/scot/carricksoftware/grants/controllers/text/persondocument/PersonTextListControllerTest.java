/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.persondocument;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.controllers.text.persontext.PersonTextListControllerImpl;
import scot.carricksoftware.grants.domains.text.PersonText;
import scot.carricksoftware.grants.services.text.persontext.PersonTextService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomPersonText;


@ExtendWith(MockitoExtension.class)
public class PersonTextListControllerTest {

    private PersonTextListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private PersonTextService personTextServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<PersonText> personTextListMock;

    @BeforeEach
    public void setUp() {
        controller = new PersonTextListControllerImpl(controllerHelperMock, personTextServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(personTextServiceMock.getPagedPersonTexts(0)).thenReturn(personTextListMock);
        assertEquals("text/personText/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("personTexts", personTextListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(personTextServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("text/personText/list", controller.getLastPage(modelMock));
        verify(personTextServiceMock, times(2)).getPagedPersonTexts(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/personTexts", controller.PersonTextDelete(Long.toString(id)));
        verify(personTextServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<PersonText> personTextList = new ArrayList<>();
        personTextList.add(GetRandomPersonText());
        when(personTextServiceMock.getPagedPersonTexts(0)).thenReturn(personTextList);

        assertEquals("text/personText/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("personTexts", personTextList);
    }

    @Test
    public void getNextPlaceTest() {
        List<PersonText> personTextList = new ArrayList<>();
        personTextList.add(GetRandomPersonText());
        when(personTextServiceMock.getPagedPersonTexts(0)).thenReturn(personTextList);

        controller.getFirstPage(modelMock);
        assertEquals("text/personText/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("personTexts", personTextList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<PersonText> personTextList = new ArrayList<>();
        personTextList.add(GetRandomPersonText());
        when(personTextServiceMock.getPagedPersonTexts(0)).thenReturn(personTextList);

        controller.getFirstPage(modelMock);
        assertEquals("text/personText/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("personTexts", personTextList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(personTextServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("text/personText/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
