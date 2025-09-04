/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class PersonSectionContentsWriterTest {

    private PersonSectionContentsWriter writer;

    @BeforeEach
    void setUp() {
        writer = new PersonSectionContentsWriterImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(writer);
    }
}