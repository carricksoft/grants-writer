/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.sections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.headers.PersonSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionReferencesWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionTimeLineWriter;

import static org.mockito.Mockito.verify;

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

    @BeforeEach
    void setUp() {
        personSection = new PersonSectionImpl(personSectionHeaderMock, personSubSectionTimeLineWriterMock, personSubSectionReferencesWriterMock);
    }

    @Test
    void writeTest() {
        personSection.write(personMock);
        verify(personSectionHeaderMock).write(personMock);
        verify(personSubSectionTimeLineWriterMock).write(personMock);
        verify(personSubSectionReferencesWriterMock).write(personMock);
    }
}