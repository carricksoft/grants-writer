/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.sections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class PersonSectionTest {

    private PersonSection personSection;

    @BeforeEach
    void setUp() {
        personSection = new PersonSectionImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(personSection);
    }
}