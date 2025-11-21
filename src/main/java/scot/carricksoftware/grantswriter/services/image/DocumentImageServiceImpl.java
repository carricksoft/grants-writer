/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import scot.carricksoftware.grantswriter.domains.images.DocumentImage;
import scot.carricksoftware.grantswriter.repositories.images.DocumentImageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentImageServiceImpl implements DocumentImageService {

    private static final Logger logger = LogManager.getLogger(DocumentImageServiceImpl.class);

    private final DocumentImageRepository documentImageRepository;

    public DocumentImageServiceImpl(DocumentImageRepository documentImageRepository) {
        this.documentImageRepository = documentImageRepository;
    }

    @Override
    public List<DocumentImage> findAll() {
        logger.debug("DocumentServiceImpl::findAllByPerson");
        List<DocumentImage> result = new ArrayList<>();
        Iterable<DocumentImage> documentImageIterable = documentImageRepository.findAll();
        for (DocumentImage documentImage : documentImageIterable) {
            result.add(documentImage);
        }
        return result;
    }

    @Override
    public DocumentImage findById(Long id) {
        return documentImageRepository.findById(id);
    }
}
