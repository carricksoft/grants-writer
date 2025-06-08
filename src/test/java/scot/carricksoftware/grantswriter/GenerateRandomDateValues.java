/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@SuppressWarnings("unused")
@Component
public class GenerateRandomDateValues {

    @SuppressWarnings("unused")
    public static Date GetRandomDate() {
        return Date.valueOf(LocalDate.now());
    }


}
