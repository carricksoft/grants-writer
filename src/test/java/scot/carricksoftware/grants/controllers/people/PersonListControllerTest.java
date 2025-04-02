/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


@ExtendWith(MockitoExtension.class)
public class PersonListControllerTest {

    private PersonListController controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Person> personListMock;

    @BeforeEach
    public void setUp() {
        controller = new PersonListControllerImpl(controllerHelperMock, personServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(personServiceMock.getPagedPersons(0)).thenReturn(personListMock);
        assertEquals("person/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("people", personListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(personServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("person/list", controller.getLastPage(modelMock));
        verify(personServiceMock, times(2)).getPagedPersons(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/people", controller.personDelete(Long.toString(id)));
        verify(personServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<Person> personList = new ArrayList<>();
        personList.add(GetRandomPerson());
        when(personServiceMock.getPagedPersons(0)).thenReturn(personList);

        assertEquals("person/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("people", personList);
    }

    @Test
    public void getNextPlaceTest() {
        List<Person> personList = new ArrayList<>();
        personList.add(GetRandomPerson());
        when(personServiceMock.getPagedPersons(0)).thenReturn(personList);

        controller.getFirstPage(modelMock);
        assertEquals("person/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("people", personList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<Person> personList = new ArrayList<>();
        personList.add(GetRandomPerson());
        when(personServiceMock.getPagedPersons(0)).thenReturn(personList);

        controller.getFirstPage(modelMock);
        assertEquals("person/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("people", personList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(personServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("person/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
