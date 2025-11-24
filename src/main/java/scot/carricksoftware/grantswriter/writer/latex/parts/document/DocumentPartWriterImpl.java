/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.document;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.writer.latex.parts.SentenceCombinedList;

@Component
public class DocumentPartWriterImpl implements DocumentPartWriter {

    private static final Logger logger = LogManager.getLogger(DocumentPartWriterImpl.class);

    private final CombinedService combinedService;
    private final SentenceCombinedList sentenceCombinedList;

    public DocumentPartWriterImpl(
            CombinedService combinedService,
            SentenceCombinedList sentenceCombinedList) {
        this.combinedService = combinedService;
        this.sentenceCombinedList = sentenceCombinedList;
    }

    public void write() {
        logger.debug("DocumentPartsImpl::write()");
        sentenceCombinedList.sentence(combinedService.getDocumentContent().getList());
    }

}
