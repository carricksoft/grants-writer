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
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.text.AppendixTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;

import java.util.List;

@Component
public class AppendixPartWriterImpl implements AppendixPartWriter {

    private static final Logger logger = LogManager.getLogger(AppendixPartWriterImpl.class);

    private final AppendixPartHeader appendixPartHeader;
    private final CombinedService combinedService;
    private final WriteBaseText writeBaseText;
    private final AppendixTextService appendixTextService;

    public AppendixPartWriterImpl(AppendixPartHeader appendixPartHeader,
                                  CombinedService combinedService,
                                  WriteBaseText writeBaseText,
                                  AppendixTextService appendixTextService) {
        this.appendixPartHeader = appendixPartHeader;
        this.combinedService = combinedService;
        this.writeBaseText = writeBaseText;
        this.appendixTextService = appendixTextService;
    }


    public void write() {
        logger.debug("AppendixPartsImpl::write()");
        appendixPartHeader.write();

        List<Combined> combinedList = combinedService.getAppendixContent().getList();
        for (Combined combined : combinedList) {
            if (combined.getContentType().equals(CombinedContentType.TEXT.label)) {
                writeBaseText.write(appendixTextService.findById(combined.getContentId()));
            }
        }
    }

}
