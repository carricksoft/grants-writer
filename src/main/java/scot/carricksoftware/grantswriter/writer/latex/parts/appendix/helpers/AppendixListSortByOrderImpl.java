/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;

import java.util.Comparator;
import java.util.List;

@Component
public class AppendixListSortByOrderImpl implements AppendixListSortByOrder {

    @Override
    public void sort(List<AppendixText> appendixTextList) {
        appendixTextList.sort(Comparator.comparing(AppendixText::getOrder));
    }
}
