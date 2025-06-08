/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.enums.census.CensusBoundaryType;
import scot.carricksoftware.grantswriter.enums.census.CensusDate;


import java.util.Random;

@SuppressWarnings("unused")
@Component
public class GenerateCensusRandomEnums {

    public static CensusBoundaryType GetRandomCensusBoundaryType() {

        CensusBoundaryType[] boundaryTypes = CensusBoundaryType.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, boundaryTypes.length);
        return boundaryTypes[randomInt];
    }

    public static CensusDate GetRandomCensusDate() {

        CensusDate[] dates = CensusDate.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, dates.length);
        return dates[randomInt];
    }


}
