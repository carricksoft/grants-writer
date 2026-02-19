/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.headers;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.writer.latex.LatexSectionHeader;

@Component
public class PlaceSectionHeaderImpl implements PlaceSectionHeader {

    private final LatexSectionHeader latexSectionHeader;

    public PlaceSectionHeaderImpl(LatexSectionHeader latexSectionHeader) {
        this.latexSectionHeader = latexSectionHeader;
    }

    @Override
    public void write(Place place) {
        latexSectionHeader.write(place.toString());
     }
}
