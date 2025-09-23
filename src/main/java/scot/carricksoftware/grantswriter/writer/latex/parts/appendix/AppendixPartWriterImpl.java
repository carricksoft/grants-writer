/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;
import scot.carricksoftware.grantswriter.services.text.AppendixTextService;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexDivisionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.helpers.AppendixListSortByOrder;

import java.util.List;

@Component
public class AppendixPartWriterImpl implements AppendixPartWriter {

    private static final Logger logger = LogManager.getLogger(AppendixPartWriterImpl.class);

    private final AppendixPartHeader appendixPartHeader;
    private final AppendixTextService appendixTextService;
    private final FileWriter fileWriter;
    private final LatexDivisionHeader latexDivisionHeader;
    private final AppendixListSortByOrder appendixListSortByOrder;

    public AppendixPartWriterImpl(AppendixPartHeader appendixPartHeader,
                                  AppendixTextService appendixTextService,
                                  FileWriter fileWriter,
                                  LatexDivisionHeader latexDivisionHeader,
                                  AppendixListSortByOrder appendixListSortByOrder) {
        this.appendixPartHeader = appendixPartHeader;
        this.appendixTextService = appendixTextService;
        this.fileWriter = fileWriter;
        this.latexDivisionHeader = latexDivisionHeader;
        this.appendixListSortByOrder = appendixListSortByOrder;
    }

    @Override
    public void write() {
        logger.debug("AppendixPartsImpl::write()");
        appendixPartHeader.write();

        List<AppendixText> appendixTextList = appendixTextService.findAll();
        appendixListSortByOrder.sort(appendixTextList);
        for (AppendixText appendixText : appendixTextList) {
                if (appendixText.getHeading() != null) {
                    latexDivisionHeader.write(Integer.parseInt(appendixText.getLevel()), appendixText.getHeading());
                }
                writeContent (appendixText);
        }
    }

    private void writeContent(AppendixText appendixText) {
        logger.debug("AppendixPartWriterImpl::writeContent()");
        fileWriter.writeLine(appendixText.getContent());
    }
}
