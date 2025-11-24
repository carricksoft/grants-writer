/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.writer.latex.parts.SentenceCombinedList;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;

@Component
public class AppendixPartWriterImpl implements AppendixPartWriter {

    private static final Logger logger = LogManager.getLogger(AppendixPartWriterImpl.class);

    private final AppendixPartHeader appendixPartHeader;
    private final CombinedService combinedService;
    private final SentenceCombinedList sentenceCombinedList;

    public AppendixPartWriterImpl(AppendixPartHeader appendixPartHeader,
                                  CombinedService combinedService,
                                  SentenceCombinedList sentenceCombinedList) {
        this.appendixPartHeader = appendixPartHeader;
        this.combinedService = combinedService;
        this.sentenceCombinedList = sentenceCombinedList;
    }

    public void write() {
        logger.debug("AppendixPartsImpl::write()");
        appendixPartHeader.write();

        sentenceCombinedList.sentence(combinedService.getAppendixContent().getList());

    }

}
