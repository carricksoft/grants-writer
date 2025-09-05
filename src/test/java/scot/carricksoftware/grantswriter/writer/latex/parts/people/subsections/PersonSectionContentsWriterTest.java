/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scot.carricksoftware.grantswriter.services.text.PersonTextService;
import scot.carricksoftware.grantswriter.writer.FileWriter;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class PersonSectionContentsWriterTest {

    private PersonSectionContentsWriter writer;

    @Mock
    private PersonTextService personTextServiceMock;

    @Mock
    private FileWriter fileWriterMock;

    @BeforeEach
    void setUp() {
        writer = new PersonSectionContentsWriterImpl(personTextServiceMock, fileWriterMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(writer);
    }
}