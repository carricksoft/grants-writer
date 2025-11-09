/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;

import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.domains.people.Person;

public interface CombinedService {
    CombinedContentList getPersonContent(Person person);

    CombinedContentList getAppendixContent();

}
