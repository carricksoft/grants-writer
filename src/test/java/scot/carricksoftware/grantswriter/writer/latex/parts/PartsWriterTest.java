/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PeoplePartWriter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class PartsWriterTest {

    private PartsWriter partsWriter;

    @Mock
    PeoplePartWriter peoplePartWriterMock;


    @BeforeEach
    void setUp() {
        partsWriter = new PartsWriterImpl(peoplePartWriterMock);
    }

    @Test
    void constructorTest() {
        assertNotNull(partsWriter);
    }

    @Test
    void writeTest() {
        partsWriter.write();
        verify(peoplePartWriterMock).write();
    }
}
