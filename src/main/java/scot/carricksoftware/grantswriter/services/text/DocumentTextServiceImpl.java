/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.services.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.text.DocumentText;
import scot.carricksoftware.grantswriter.repositories.text.DocumentTextRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentTextServiceImpl extends TextServiceImpl implements DocumentTextService {
    private static final Logger logger = LogManager.getLogger(DocumentTextServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final DocumentTextRepository documentTextRepository;

    public DocumentTextServiceImpl(DocumentTextRepository documentTextRepository) {
        this.documentTextRepository = documentTextRepository;
    }

    @Override
    public List<DocumentText> findAll() {
        logger.debug("DocumentTextServiceImpl::findAll");
        List<DocumentText> result = new ArrayList<>();
        Iterable<DocumentText> documentTextIterable = documentTextRepository.findAll();
        documentTextIterable.forEach(result::add);
        return result;
    }

    @Override
    public DocumentText findById(Long id) {
        return documentTextRepository.findById(id);
    }

}
