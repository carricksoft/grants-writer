/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.text.PersonText;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class PersonListSortByOrderTest {

    private PersonListSortByOrder sorter;

    private final List<PersonText> personTextList = new ArrayList<>();

    private final PersonText lowOrder = new PersonText();
    private final PersonText highOrder = new PersonText();

    @BeforeEach
    void setUp() {
        lowOrder.setOrder("1");
        highOrder.setOrder("2");
        personTextList.add(highOrder);
        personTextList.add(lowOrder);

        sorter = new PersonListSortByOrderImpl();
    }

    @Test
    void sortTest() {
        assertTrue(personTextList.lastIndexOf(highOrder) < personTextList.lastIndexOf(lowOrder));
        sorter.sort(personTextList);
        assertTrue(personTextList.lastIndexOf(lowOrder) < personTextList.lastIndexOf(highOrder));
    }
}