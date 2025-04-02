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
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPersonCommand;


@ExtendWith(MockitoExtension.class)
public class PersonServiceSaveTest {

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


    @Test
    public void saveTest() {
        Person person = GetRandomPerson();
        when(personRepositoryMock.save(person)).thenReturn(person);

        assertEquals(person, personService.save(person));
    }

    @Test
    public void savePersonCommandTest() {
        Person person = GetRandomPerson();
        PersonCommand personCommand = GetRandomPersonCommand();
        when(personCommandConverterImplMock.convert(personCommand)).thenReturn(person);
        when(personRepositoryMock.save(person)).thenReturn(person);
        when(personConverterImplMock.convert((person))).thenReturn(personCommand);

        assertEquals(personCommand, personService.savePersonCommand(personCommand));
    }


}