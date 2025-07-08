/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import scot.carricksoftware.grantswriter.domains.people.Person;

public interface GatherBirthCertificateTimeLineData {
    @SuppressWarnings("unused")
    void gatherNewBorn(Person person);

    @SuppressWarnings("unused")
    void gatherFather(Person person);

    @SuppressWarnings("unused")
    void gatherMother(Person person);

    @SuppressWarnings("unused")
    void gatherInformant(Person person);

}
