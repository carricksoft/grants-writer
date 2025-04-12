/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:13. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;

@Component
public class CensusEntryConverterImpl implements CensusEntryConverter {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public CensusEntryCommand convert(CensusEntry source) {
        CensusEntryCommand result = new CensusEntryCommandImpl();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setCensus(source.getCensus());
        result.setPerson(source.getPerson());
        result.setRelationship(source.getRelationship());
        result.setCondition(source.getCondition());
        return result;
    }
}
