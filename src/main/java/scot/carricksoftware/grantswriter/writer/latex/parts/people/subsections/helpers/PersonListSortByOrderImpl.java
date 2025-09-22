/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.text.PersonText;

import java.util.Comparator;
import java.util.List;

@Component
public class PersonListSortByOrderImpl implements PersonListSortByOrder {

    @Override
    public void sort(List<PersonText> personTextList) {
        personTextList.sort(Comparator.comparing(PersonText::getOrder));
    }
}
