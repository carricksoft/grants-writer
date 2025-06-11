/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@Component
public class LatexPackageDeclarationImpl implements LatexPackageDeclaration {

    private final FileWriter fileWriter;

    public LatexPackageDeclarationImpl(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void write(String packageName) {
        String sb = LatexConstants.USE_PACKAGE_TERM +
                packageName +
                LatexConstants.TERM_END;
        fileWriter.writeLine(sb);
    }
}
