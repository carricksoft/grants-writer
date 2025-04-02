/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:06. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.census.CensusEntry;

@SuppressWarnings("NullableProblems")
public interface CensusEntryConverter extends Converter<CensusEntry, CensusEntryCommand> {
    CensusEntryCommand convert(CensusEntry censusEntry);
}
