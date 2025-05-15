/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class WriterFilesImpl implements WriterFiles {

    private static final Logger logger = LogManager.getLogger(WriterFilesImpl.class);

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

    @Override
    public void init() {
        logger.debug("WriterFiles::init");
        setLatexFileName(System.getProperty("user.home") + File.separator + "carricksoftware" + File.separator + "grants.tex");
        setPdfFileName(System.getProperty("user.home") + File.separator + "carricksoftware" + File.separator + "grants.pdf");
    }
}
