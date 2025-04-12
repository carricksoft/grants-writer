/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryCondition;

import java.util.Random;

@SuppressWarnings("unused")
@Component
public class GenerateCensusEntryConditionRandomValue {

    public static CensusEntryCondition GetRandomCensusEntryCondition() {

        CensusEntryCondition[] conditions = CensusEntryCondition.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, conditions.length );
        return conditions[randomInt];
    }



}
