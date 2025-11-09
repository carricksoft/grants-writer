/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentType;
import scot.carricksoftware.grantswriter.domains.text.AppendixText;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.text.AppendixTextService;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;

import java.util.List;

@Component
public class AppendixPartWriterImpl implements AppendixPartWriter {

    private static final Logger logger = LogManager.getLogger(AppendixPartWriterImpl.class);

    private final AppendixPartHeader appendixPartHeader;
    private final AppendixTextService appendixTextService;
    private final FileWriter fileWriter;
    private final CombinedService combinedService;

    public AppendixPartWriterImpl(AppendixPartHeader appendixPartHeader,
                                  AppendixTextService appendixTextService,
                                  CombinedService combinedService,
                                  FileWriter fileWriter) {
        this.appendixPartHeader = appendixPartHeader;
        this.appendixTextService = appendixTextService;
        this.combinedService = combinedService;
        this.fileWriter = fileWriter;
    }

    @Override
    public void write() {
        logger.debug("AppendixPartsImpl::write()");
        appendixPartHeader.write();


       List<Combined> combinedList = combinedService.getAppendixContent().getList();
        for (Combined combined : combinedList) {
           if (combined.getContentType().equals(CombinedContentType.TEXT.label)) {
                writeAppendixText(combined.getContentId());
           }
        }
    }

    private void writeAppendixText(Long id) {
        logger.debug("AppendixPartWriterImpl::writeContent()");
        AppendixText appendixText = appendixTextService.findById(id);
        fileWriter.writeLine(appendixText.getContent());
    }
}
