/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 23:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CapitalisationTest {

    private Capitalisation capitalisation;

    @BeforeEach
    public void setUp() {
        capitalisation = new CapitalisationImpl();
    }

    @Test
    public void firstTest() {
        assertEquals("Smith", capitalisation.getCapitalisation("Smith"));
    }

    @Test
    public void secondTest() {
        assertEquals("Smith", capitalisation.getCapitalisation("smith"));
    }

    @Test
    public void thirdTest() {
        assertEquals("Smith", capitalisation.getCapitalisation("SMITH"));
    }

    @Test
    public void fourthTest() {
        assertEquals("Smith Jones", capitalisation.getCapitalisation("smith jones"));
    }

    @Test
    public void fifthTest() {
        assertEquals("Smith-Jones", capitalisation.getCapitalisation("smith-jones"));
    }

    @Test
    public void sixthTest() {
        assertEquals("McSmith", capitalisation.getCapitalisation("mcSmith"));
    }

    @Test
    public void seventhTest() {
        //noinspection SpellCheckingInspection
        assertEquals("Macsmith", capitalisation.getCapitalisation("macsmith"));
    }

    @Test
    public void eighthTest() {
        assertEquals("MacSmith", capitalisation.getCapitalisation("macSmith"));
    }

    @Test
    public void ninthTest() {
        //noinspection SpellCheckingInspection
        assertEquals("McSmith", capitalisation.getCapitalisation("mcsmith"));
    }

    @Test
    public void nullTest() {
        assertEquals("", capitalisation.getCapitalisation(null));
    }


}
