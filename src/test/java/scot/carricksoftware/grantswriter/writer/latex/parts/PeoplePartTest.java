/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.people.PersonService;
import scot.carricksoftware.grantswriter.writer.latex.sections.PersonSection;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class PeoplePartTest {

    private PeoplePart peoplePart;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonSection personSectionMock;

    @SuppressWarnings("EmptyMethod")
    @BeforeEach
    void setUp() {
        peoplePart = new PeoplePartImpl(personServiceMock, personSectionMock);
    }

    @Test
    void writeTest() {
        List<Person> people = new ArrayList<>();
        int limit = 10;
        for (int i = 0; i < limit; i++) {
            Person person = GetRandomPerson();
            people.add(person);
        }

        when(personServiceMock.findAll()).thenReturn(people);

        peoplePart.write();
        verify(personSectionMock, times(limit)).write(any());
    }
}