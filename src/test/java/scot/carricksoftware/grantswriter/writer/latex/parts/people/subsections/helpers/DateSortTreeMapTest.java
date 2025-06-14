/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class DateSortTreeMapTest {
    private DateSortTreeMap dateSortTreeMap;

    @BeforeEach
    void setUp() {
        dateSortTreeMap = new DateSortTreeMapImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(dateSortTreeMap);
    }

}