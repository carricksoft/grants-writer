/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.sections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonSubSectionReferencesWriterTest {

    private PersonSubSectionReferencesWriter writer;

    @Mock
    private LatexSubSectionHeader latexSubSectionHeaderMock;

    @Mock
    private Person personMock;

    @BeforeEach
    void setUp() {
        writer = new PersonSubSectionReferencesWriterImpl(latexSubSectionHeaderMock);
    }

    @Test
    void writeTest() {
        writer.write(personMock);
        verify(latexSubSectionHeaderMock).write("References");
    }
}