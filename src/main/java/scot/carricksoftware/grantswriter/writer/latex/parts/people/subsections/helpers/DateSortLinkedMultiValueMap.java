/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.springframework.util.LinkedMultiValueMap;

public interface DateSortLinkedMultiValueMap {

    @SuppressWarnings("SameReturnValue")
    LinkedMultiValueMap<String, String> sort (@SuppressWarnings("unused") LinkedMultiValueMap<String, String> map);
}
