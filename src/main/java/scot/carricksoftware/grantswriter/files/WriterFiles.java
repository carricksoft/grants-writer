/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.files;

public interface WriterFiles {
    String getDirectory();

    void setDirectory(String directory);

    String getInputFileName();

    void setInputFileName(String inputFileName);

    String getLatexFileName();

    void setLatexFileName(String latexFileName);

    String getPdfFileName();

    void setPdfFileName(String pdfFileName);
}
