/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.document;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentType;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.image.DocumentImageService;
import scot.carricksoftware.grantswriter.services.text.DocumentTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseImage;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;

import java.util.List;

@Component
public class DocumentPartWriterImpl implements DocumentPartWriter {

    private static final Logger logger = LogManager.getLogger(DocumentPartWriterImpl.class);

    private final WriteBaseText writeBaseText;
    private final WriteBaseImage writeBaseImage;
    private final DocumentTextService documentTextService;
    private final DocumentImageService documentImageService;
    private final CombinedService combinedService;

    public DocumentPartWriterImpl(WriteBaseText writeBaseText, WriteBaseImage writeBaseImage, DocumentTextService documentTextService, DocumentImageService documentImageService, CombinedService combinedService) {
        this.writeBaseText = writeBaseText;
        this.writeBaseImage = writeBaseImage;
        this.documentTextService = documentTextService;
        this.documentImageService = documentImageService;
        this.combinedService = combinedService;
    }


    @SuppressWarnings("DuplicatedCode")
    public void write() {
        logger.debug("DocumentPartsImpl::write()");

        List<Combined> combinedList = combinedService.getDocumentContent().getList();

        for (Combined combined : combinedList) {
            if (combined.getContentType().equals(CombinedContentType.TEXT.label)) {
                writeBaseText.write(documentTextService.findById(combined.getContentId()));
            } else {
                if (combined.getContentType().equals(CombinedContentType.IMAGE.label)) {
                    writeBaseImage.write(documentImageService.findById(combined.getContentId()));
                }
            }
        }


    }

}
