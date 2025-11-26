/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@SuppressWarnings("SpellCheckingInspection")
@Component
public class LatexDocumentStartImpl implements LatexDocumentStart {

    private static final Logger logger = LogManager.getLogger(LatexDocumentStartImpl.class);

    private final FileWriter fileWriter;

    private final LatexPackageDeclaration latexPackageDeclaration;

    public LatexDocumentStartImpl(FileWriter fileWriter,
                                  LatexPackageDeclaration latexPackageDeclaration) {
        this.fileWriter = fileWriter;
        this.latexPackageDeclaration = latexPackageDeclaration;
    }

    @Override
    public void write() {
        logger.info("LatexDocumentStartImpl.write()");
        fileWriter.writeLine(LatexConstants.DOCUMENT_CLASS);
        latexPackageDeclaration.write("longtable","");
        latexPackageDeclaration.write("adjustbox", "export");
        latexPackageDeclaration.write("placeins", "");
        fileWriter.writeLine(LatexConstants.SECTION_NUMBERING);
        fileWriter.writeLine(LatexConstants.DOCUMENT_START);
    }
}
