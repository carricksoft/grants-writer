/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.time.LocalDate;

import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SuppressWarnings("unused")
@Component
public class GenerateRandomCensusValues {

    @SuppressWarnings("unused")
    public static Census GetRandomCensus() {
        Census census = new Census();
        census.setId(GetRandomLong());
        census.setDate(LocalDate.now());
        return census;
    }

    public static CensusCommand GetRandomCensusCommand() {
        CensusCommand censusCommand = new CensusCommandImpl();
        censusCommand.setId(GetRandomLong());
        censusCommand.setDate(LocalDate.now());
        return censusCommand;
    }

    public static CensusEntry GetRandomCensusEntry() {
        CensusEntry censusEntry = new CensusEntry();
        censusEntry.setId(GetRandomLong());
        censusEntry.setName(GetRandomString());
        return censusEntry;
    }

    public static CensusEntryCommand GetRandomCensusEntryCommand() {
        CensusEntryCommand censusEntryCommand = new CensusEntryCommandImpl();
        censusEntryCommand.setId(GetRandomLong());
        censusEntryCommand.setName(GetRandomString());
        return censusEntryCommand;
    }

}
