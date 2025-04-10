/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryRelationship;

import java.util.Random;

@SuppressWarnings("unused")
@Component
public class GenerateCensusEntryRelationshipRandomValue {

    public static CensusEntryRelationship GetRandomCensusEntryRelationship() {

        CensusEntryRelationship[] relationships = CensusEntryRelationship.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, relationships.length );
        return relationships[randomInt];
    }



}
