/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentType;
import scot.carricksoftware.grantswriter.services.image.DocumentImageService;
import scot.carricksoftware.grantswriter.services.text.DocumentTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseImage;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;

import java.util.List;

@Component
public class SentenceCombinedListImpl implements SentenceCombinedList {

    private final WriteBaseText writeBaseText;
    private final WriteBaseImage writeBaseImage;
    private final DocumentTextService documentTextService;
    private final DocumentImageService documentImageService;

    public SentenceCombinedListImpl(WriteBaseText writeBaseText, WriteBaseImage writeBaseImage, DocumentTextService documentTextService, DocumentImageService documentImageService) {
        this.writeBaseText = writeBaseText;
        this.writeBaseImage = writeBaseImage;
        this.documentTextService = documentTextService;
        this.documentImageService = documentImageService;
    }

    @Override
    public void sentence(List<Combined> combinedList) {
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
