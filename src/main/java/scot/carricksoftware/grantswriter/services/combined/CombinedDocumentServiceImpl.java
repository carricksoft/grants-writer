/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.combined.CombinedContentListImpl;
import scot.carricksoftware.grantswriter.domains.images.DocumentImage;
import scot.carricksoftware.grantswriter.domains.text.DocumentText;
import scot.carricksoftware.grantswriter.repositories.images.DocumentImageRepository;
import scot.carricksoftware.grantswriter.repositories.text.DocumentTextRepository;

@Component
public class CombinedDocumentServiceImpl implements CombinedDocumentService {

    private final DocumentTextRepository documentTextRepository;
    private final DocumentImageRepository documentImageRepository;

    public CombinedDocumentServiceImpl(DocumentTextRepository documentTextRepository,
                                       DocumentImageRepository documentImageRepository) {
        this.documentTextRepository = documentTextRepository;
        this.documentImageRepository = documentImageRepository;
    }

    @Override
    public CombinedContentList getDocumentContent() {
        CombinedContentList result = new CombinedContentListImpl();
        addDocumentText(result);
        addDocumentImage(result);
        result.sort();
        return result;
    }

    private void addDocumentText(CombinedContentList result) {
        Iterable<DocumentText> documentIterable = documentTextRepository.findAll();
        for (DocumentText documentText : documentIterable) {
            result.addBaseText(documentText);
        }
    }

    private void addDocumentImage(CombinedContentList result) {
        Iterable<DocumentImage> documentImageIterable = documentImageRepository.findAll();
        for (DocumentImage documentImage : documentImageIterable) {
            result.addBaseImage(documentImage);
        }
    }

}
