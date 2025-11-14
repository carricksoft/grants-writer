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
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.combined.CombinedImpl;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.text.PersonTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class PersonSectionContentsWriterTest {

    private PersonSectionContentsWriter personSectionContentsWriter;

    @Mock private PersonTextService personTextServiceMock;
    @Mock private CombinedService combinedServiceMock;
    @Mock private WriteBaseText writeBaseTextMock;

    @Mock
    private CombinedContentList combinedContentListMock;

    private final List<Combined> combinedList = new ArrayList<>();

    private Combined combined;

    private Person person;

    @BeforeEach
    void setUp() {
        personSectionContentsWriter = new PersonSectionContentsWriterImpl(personTextServiceMock, combinedServiceMock, writeBaseTextMock);
        combined = new CombinedImpl();
        person = GetRandomPerson();
        when(combinedServiceMock.getPersonContent(person)).thenReturn(combinedContentListMock);
    }

    @Test
    void textsAreCorrectlyRoutedTest() {
        combined.setContentType("text");
        combinedList.add(combined);
        PersonText personText = new PersonText();
        when(combinedContentListMock.getList()).thenReturn(combinedList);
        when(personTextServiceMock.findById(any())).thenReturn(personText);

        personSectionContentsWriter.write(person);
        verify(writeBaseTextMock).write(personText);
    }
}