/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.LatexSubSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.WriteReferences;

@Component
public class PersonSubSectionReferencesWriterImpl implements PersonSubSectionReferencesWriter {

    private final LatexSubSectionHeader latexSubSectionHeader;
    private final WriteReferences writeReferences;

    public PersonSubSectionReferencesWriterImpl(
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
