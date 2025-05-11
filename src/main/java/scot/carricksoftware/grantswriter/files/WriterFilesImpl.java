/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.files;

import org.springframework.stereotype.Component;


@Component
public class WriterFilesImpl implements WriterFiles {

    private String latexFileName;
    private String pdfFileName;


    @Override
    public String getLatexFileName() {
        return latexFileName;
    }

    @Override
    public void setLatexFileName(String latexFileName) {
        this.latexFileName = latexFileName;
    }

    @Override
    public String getPdfFileName() {
        return pdfFileName;
    }

    @Override
    public void setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
    }
}
