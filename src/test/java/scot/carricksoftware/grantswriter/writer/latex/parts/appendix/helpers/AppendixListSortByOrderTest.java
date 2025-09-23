/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class AppendixListSortByOrderTest {

    private AppendixListSortByOrder sorter;

    private final List<AppendixText> appendixTextList = new ArrayList<>();

    private final AppendixText lowOrder = new AppendixText();
    private final AppendixText highOrder = new AppendixText();

    @BeforeEach
    void setUp() {
        lowOrder.setOrder("1");
        highOrder.setOrder("2");
        appendixTextList.add(highOrder);
        appendixTextList.add(lowOrder);

        sorter = new AppendixListSortByOrderImpl();
    }

    @Test
    void sortTest() {
        assertTrue( appendixTextList.lastIndexOf(highOrder) < appendixTextList.lastIndexOf(lowOrder));
        sorter.sort(appendixTextList);
        assertTrue( appendixTextList.lastIndexOf(lowOrder) < appendixTextList.lastIndexOf(highOrder));
    }
}