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
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PersonSectionHeader;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonSectionTest {

    private PersonSection personSection;

    @Mock
    private PersonSectionHeader personSectionHeaderMock;

    @Mock
    private Person personMock;

    @BeforeEach
    void setUp() {
        personSection = new PersonSectionImpl(personSectionHeaderMock);
    }

    @Test
    void writeTest() {
        personSection.write(personMock);
        verify(personSectionHeaderMock).write(personMock);
    }
}