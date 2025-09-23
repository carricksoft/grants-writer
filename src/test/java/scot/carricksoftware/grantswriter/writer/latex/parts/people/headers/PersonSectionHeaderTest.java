/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.headers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.writer.latex.LatexSectionHeader;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonSectionHeaderTest {

    private PersonSectionHeader personSectionHeader;

    @Mock LatexSectionHeader latexSectionHeaderMock;
    @Mock Person personMock;

    @BeforeEach
    void setUp() {
        personSectionHeader = new PersonSectionHeaderImpl(latexSectionHeaderMock);
    }

    @Test
    void writeTest() {
        String toString = personSectionHeader.toString();
        when(personMock.toString()).thenReturn(toString);
        personSectionHeader.write(personMock);
        verify(latexSectionHeaderMock).write(toString);
    }
}