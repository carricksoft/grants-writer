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
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexDivisionHeader;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class PersonSectionContentsWriterTest {

    private PersonSectionContentsWriter writer;

    @Mock private PersonTextService personTextServiceMock;
    @Mock private CombinedService combinedServiceMock;
    @Mock private FileWriter fileWriterMock;
    @Mock private LatexDivisionHeader latexDivisionHeaderMock;
    @Mock private CombinedContentList combinedContentListMock;

    @BeforeEach
    void setUp() {
        writer = new PersonSectionContentsWriterImpl(
                personTextServiceMock,
                combinedServiceMock,
                fileWriterMock,
                latexDivisionHeaderMock
                );
    }


    @Test
    void thePersonTextIsWrittenTest() {
        Person person = new Person();
        Combined combined = new CombinedImpl();
        combined.setContentId(1L);
        combined.setContentType("text");
        String content = GetRandomString();
        String heading = GetRandomString();
        String level = "99";
        PersonText personText = new PersonText();
        personText.setContent(content);
        personText.setHeading(heading);
        personText.setLevel(level);
        List<Combined> combinedList = new ArrayList<>();
        combinedList.add(combined);
        when(combinedServiceMock.getPersonContent(person)).thenReturn(combinedContentListMock);
        when(combinedContentListMock.getList()).thenReturn(combinedList);
        when(personTextServiceMock.findById(1L)).thenReturn(personText);
        writer.write(person);
        verify(latexDivisionHeaderMock).write(99, heading);
        verify(fileWriterMock).writeLine(content);
    }

}