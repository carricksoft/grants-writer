/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.text;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.repositories.text.PersonTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class PersonTextServiceTest {

    private PersonTextService personTextService;

    @Mock private PersonTextRepository personTextRepositoryMock;

    private Person person;

    @BeforeEach
    void setUp() {
        personTextService = new PersonTextServiceImpl(personTextRepositoryMock);
        person = GetRandomPerson();
    }

    @Test
    void testFindAllByPersonTest() {
        List<PersonText> personTextList = new ArrayList<>();
        personTextList.add(new PersonText());
        when(personTextRepositoryMock.findAllByPerson(person)).thenReturn(personTextList);
        assertEquals(personTextList, personTextService.findAllByPerson(person));
    }

}