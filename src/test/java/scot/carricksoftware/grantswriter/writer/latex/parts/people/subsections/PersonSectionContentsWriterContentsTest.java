/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.services.text.PersonTextService;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexDivisionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.PersonListSortByOrder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomInteger;


@ExtendWith(MockitoExtension.class)
class PersonSectionContentsWriterContentsTest {

    private PersonSectionContentsWriter writer;

    @Mock
    private PersonTextService personTextServiceMock;
    @Mock
    private FileWriter fileWriterMock;
    @Mock
    private LatexDivisionHeader latexDivisionHeaderMock;
    @Mock
    private PersonListSortByOrder personListSortByOrderMock;

    private List<PersonText> contents;

    private PersonText personText;

    private Person person;

    @BeforeEach
    void setUp() {
        writer = new PersonSectionContentsWriterImpl(personTextServiceMock,
                fileWriterMock,
                latexDivisionHeaderMock,
                personListSortByOrderMock);
        person = new Person();
        person.setId(99L);
        personText = new PersonText();
        personText.setId(99L);
        when(personTextServiceMock.findById(any())).thenReturn(personText);
    }


    @Test
    void withANonEmptyArrayFileWriterIsCalled() {
        contents = new ArrayList<>();
        String content = GetRandomString();
        personText.setContent(content);
        personText.setId(66L);
        contents.add(personText);
        when(personTextServiceMock.findAllByPerson(person)).thenReturn(contents);
        writer.write(person);
        verify(fileWriterMock).writeLine(content);
    }

    @Test
    void latexDivisionHeaderIsCalled() {
        contents = new ArrayList<>();
        personText.setHeading(GetRandomString());
        personText.setLevel(GetRandomInteger().toString());
        contents.add(personText);
        when(personTextServiceMock.findAllByPerson(person)).thenReturn(contents);
        writer.write(person);
        verify(latexDivisionHeaderMock).write((Integer) any(), any());
    }

    @Test
    void sortIsCalled() {
        contents = new ArrayList<>();
        contents.add(personText);
        when(personTextServiceMock.findAllByPerson(person)).thenReturn(contents);
        writer.write(person);
        verify(personListSortByOrderMock).sort(contents);
    }
}