/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.repositories.people.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    private PersonService service;

    @Mock
    private PersonRepository personRepositoryMock;

    @BeforeEach
    void setUp() {
        service = new PersonServiceImpl(personRepositoryMock);
    }


    @Test
    public void findAllTest() {
        List<Person> people = new ArrayList<>();
        people.add(GetRandomPerson());
        when(personRepositoryMock.findAll(any(Sort.class))).thenReturn(people);
        assertEquals(people, service.findAll());
    }


}