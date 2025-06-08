/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.enums.census;

public enum CensusBoundaryType {

    BURGH("Burgh"),
    CIVIL_PARISH("Civil Parish"),
    PARISH_WARD("Parish Ward"),
    @SuppressWarnings("SpellCheckingInspection") ECCLESIASTICAL_PARISH("Ecclesical Parish"),
    @SuppressWarnings("SpellCheckingInspection") QUOAD_SACRA__PARISH ("Quoad Sacra Parish"),
    SCHOOL_BOARD_DISTRICT ("School Board District"),
    PARLIAMENTARY_BURGH  ("Parliamentary Burgh"),
    PARLIAMENTARY_DIVISION("Parliamentary Division"),
    ROYAL_BURGH  ("Royal Burgh"),
    MUNICIPAL_BURGH("Municipal Burgh"),
    POLICE_BURGH  ("Police Burgh"),
    BURGH_WARD ("Burgh Ward"),
    TOWN ("Town"),
    VILLAGE_OR_HAMLET ("Village or Hamlet"),
    ISLAND ("Island");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusBoundaryType(String label) {
        this.label = label;
    }
}
