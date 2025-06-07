/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.LatexPartHeader;

@Component
public class PeoplePartHeaderImpl implements PeoplePartHeader {

    private final LatexPartHeader latexPartHeader;

    public PeoplePartHeaderImpl(LatexPartHeader latexPartHeader) {
        this.latexPartHeader = latexPartHeader;
    }

    @Override
    public void write() {
        latexPartHeader.write("People");
    }
}
