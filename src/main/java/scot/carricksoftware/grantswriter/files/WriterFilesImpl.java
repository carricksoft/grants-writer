/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.files;

public class WriterFilesImpl implements WriterFiles {

    private String directory;
    private String inputFileName;
    private String latexFileName;
    private String pdfFileName;

    @Override
    public String getDirectory() {
        return directory;
    }

    @Override
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    @Override
    public String getInputFileName() {
        return inputFileName;
    }

    @Override
    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

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
