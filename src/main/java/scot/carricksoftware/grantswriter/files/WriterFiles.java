/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.files;

public interface WriterFiles {


    String getLatexFileName();

    @SuppressWarnings("unused")
    void setLatexFileName(String latexFileName);

    String getPdfFileName();

    @SuppressWarnings("unused")
    void setPdfFileName(String pdfFileName);

    String getStatus();

    @SuppressWarnings("unused")
    void setStatus(String status);

    void init();
}
