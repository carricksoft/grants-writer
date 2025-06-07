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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class WritePartsTest {

    private WriteParts writeParts;

    @Mock
    PeoplePart peoplePartMock;

    @BeforeEach
    void setUp() {
        writeParts = new WritePartsImpl(peoplePartMock);
    }

    @Test
    void constructorTest(){
        assertNotNull(writeParts);
    }

    @Test
    void writeTest(){
        writeParts.write();
        verify(peoplePartMock).write();
    }
}
