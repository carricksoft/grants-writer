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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.headers.PeoplePartHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PeoplePartWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PeoplePartWriterImpl;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.sections.PersonSection;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class PeoplePartWriterTest {

    private PeoplePartWriter peoplePartWriter;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonSection personSectionMock;

    @Mock
    private PeoplePartHeader peopleHeaderMock;

    @SuppressWarnings("EmptyMethod")
    @BeforeEach
    void setUp() {
        peoplePartWriter = new PeoplePartWriterImpl(personServiceMock, peopleHeaderMock, personSectionMock);
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

        peoplePartWriter.write();
        verify(personSectionMock, times(limit)).write(any());
    }

    @Test
    void peopleHeaderWasCalledTest() {
        peoplePartWriter.write();
        verify(peopleHeaderMock).write();
    }
}