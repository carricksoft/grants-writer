/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteReferences;

@Component
public class PlaceSubSectionReferencesWriterImpl implements PlaceSubSectionReferencesWriter {

    private final LatexSubSectionHeader latexSubSectionHeader;
    private final WriteReferences writeReferences;

    public PlaceSubSectionReferencesWriterImpl(
            LatexSubSectionHeader latexSubSectionHeader,
            WriteReferences writeReferences) {
        this.latexSubSectionHeader = latexSubSectionHeader;
        this.writeReferences = writeReferences;
    }

    @Override
    public void write() {
        latexSubSectionHeader.write("References");
        writeReferences.write();
    }

}
