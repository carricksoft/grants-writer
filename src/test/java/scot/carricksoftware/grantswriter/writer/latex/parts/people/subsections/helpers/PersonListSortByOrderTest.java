/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class PersonListSortByOrderTest {

    private PersonListSortByOrder sorter;

    @BeforeEach
    void setUp() {
        sorter = new PersonListSortByOrderImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(sorter);
    }
}