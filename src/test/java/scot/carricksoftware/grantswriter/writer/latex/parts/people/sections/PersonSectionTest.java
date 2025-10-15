/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.sections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.headers.PersonSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSectionContentsWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionReferencesWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionTimeLineWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.ClearExistingTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.GatherTimeLineData;

import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
class PersonSectionTest {

    private PersonSection personSection;

    @Mock
    private PersonSectionHeader personSectionHeaderMock;
    @Mock
    private PersonSubSectionTimeLineWriter personSubSectionTimeLineWriterMock;
    @Mock
    private PersonSubSectionReferencesWriter personSubSectionReferencesWriterMock;
    @Mock
    private Person personMock;
    @Mock
    private GatherTimeLineData gatherTimeLineDataMock;
    @Mock
    private PersonSectionContentsWriter personSectionContentsWriterMock;
    @Mock
    ClearExistingTimeLineData clearExistingTimeLineDataMock;

    @BeforeEach
    void setUp() {
        personSection = new PersonSectionImpl(
                personSectionHeaderMock,
                personSubSectionTimeLineWriterMock,
                personSubSectionReferencesWriterMock,
                clearExistingTimeLineDataMock,
                gatherTimeLineDataMock,
                personSectionContentsWriterMock);
    }

    @Test
    void writeTest() {
        InOrder inorder = inOrder(
                personSectionHeaderMock,
                personSectionContentsWriterMock,
                clearExistingTimeLineDataMock,
                gatherTimeLineDataMock,
                personSubSectionTimeLineWriterMock,
                personSubSectionReferencesWriterMock);
        personSection.write(personMock);
        inorder.verify(personSectionHeaderMock).write(personMock);
        inorder.verify(personSectionContentsWriterMock).write(personMock);
        inorder.verify(clearExistingTimeLineDataMock).clear();
        inorder.verify(gatherTimeLineDataMock).gather(personMock);
        inorder.verify(personSubSectionTimeLineWriterMock).write();
        inorder.verify(personSubSectionReferencesWriterMock).write();
    }
}