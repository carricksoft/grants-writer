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
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
public class PersonServiceFindTest {

    PersonService personService;

    @Mock
    PersonRepository personRepositoryMock;

    @Mock
    PersonConverterImpl personConverterMock;

    @Mock
    PersonCommandConverterImpl personCommandConverterMock;

    @BeforeEach
    public void setUp() {
        personService = new PersonServiceImpl(personRepositoryMock,
                personConverterMock,
                personCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<Person> countries = new ArrayList<>();
        countries.add(GetRandomPerson());
        when(personRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, personService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();
        Optional<Person> personOptional = Optional.of(person);
        when(personRepositoryMock.findById(id)).thenReturn(personOptional);
        assertEquals(person, personService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<Person> empty = Optional.empty();
        when(personRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(personService.findById(id));
    }

}