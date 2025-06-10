/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.censusentry;

import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.people.Person;

import java.util.List;

public interface CensusEntryService {

    List<CensusEntry> findAllByPerson(Person person);
}
