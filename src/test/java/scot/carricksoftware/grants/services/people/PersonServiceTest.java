/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.people;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    PersonService personService;

    @Mock
    PersonRepository personRepositoryMock;

    @Mock
    PersonConverterImpl personConverterImplMock;

    @Mock
    PersonCommandConverterImpl personCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        personService = new PersonServiceImpl(personRepositoryMock,
                personConverterImplMock,
                personCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<Person> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        personService.deleteById(id);
        verify(personRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(personRepositoryMock.count()).thenReturn(result);
        assertEquals(result, personService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<Person> result = new ArrayList<>();
        Person person = GetRandomPerson();
        result.add(person);
        when(pageMock.getContent()).thenReturn(result);
        when(personRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, personService.getPagedPersons(0));
    }


}