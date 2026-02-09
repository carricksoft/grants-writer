/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.headers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.LatexPartHeader;


@Component
public class PlacesPartHeaderImpl implements PlacesPartHeader {

    private final LatexPartHeader latexPartHeader;

    public PlacesPartHeaderImpl(LatexPartHeader latexPartHeader) {
        this.latexPartHeader = latexPartHeader;
    }

    @Override
    public void write() {
        latexPartHeader.write("Places");
    }
}
