/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:18. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.census.CensusEntry;

@Component
public class CensusEntryCommandConverterImpl implements CensusEntryCommandConverter {

    @Override
    public CensusEntry convert(CensusEntryCommand source) {
        CensusEntry result = new CensusEntry();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setCensus(source.getCensus());
        result.setPerson(source.getPerson());
        return result;
    }


}
