/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.documenttext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.documenttext.DocumentTextConverterImpl;
import scot.carricksoftware.grants.domains.text.DocumentText;
import scot.carricksoftware.grants.repositories.text.DocumentTextRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentTextServiceImpl implements DocumentTextService {
    private static final Logger logger = LogManager.getLogger(DocumentTextServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final DocumentTextRepository documentTextRepository;
    private final DocumentTextConverterImpl documentTextConverterImpl;
    private final DocumentTextCommandConverterImpl documentTextCommandConverterImpl;

    public DocumentTextServiceImpl(
            DocumentTextRepository documentTextRepository,
            DocumentTextConverterImpl documentTextConverterImpl,
            DocumentTextCommandConverterImpl documentTextCommandConverterImpl) {

        this.documentTextRepository = documentTextRepository;
        this.documentTextConverterImpl = documentTextConverterImpl;
        this.documentTextCommandConverterImpl = documentTextCommandConverterImpl;
    }


    @Override
    public DocumentText findById(Long id) {
        logger.debug("DocumentTextServiceImpl::findById");
        Optional<DocumentText> documentTextOptional = documentTextRepository.findById(id);
        return documentTextOptional.orElse(null);
    }

    public DocumentText save(DocumentText documentText) {
        logger.debug("DocumentTextServiceImpl::save");
        return documentTextRepository.save(documentText);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("DocumentTextServiceImpl::deleteBy");
        documentTextRepository.deleteById(id);
    }

    @Override
    public List<DocumentText> getPagedDocumentTexts(int pageNumber) {
        logger.debug("DocumentTextServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<DocumentText> pagedResult = documentTextRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("DocumentTextServiceImpl::count");
        return documentTextRepository.count();
    }

    @Transactional
    @Override
    public DocumentTextCommand saveDocumentTextCommand(DocumentTextCommand documentTextCommand) {
        logger.debug("DocumentTextServiceImpl::saveDocumentTextCommand");
        DocumentText documentText = documentTextCommandConverterImpl.convert(documentTextCommand);
        DocumentText savedDocumentText = documentTextRepository.save(documentText);
        return documentTextConverterImpl.convert(savedDocumentText);

    }

    @Override
    public List<DocumentText> findAll() {
        logger.debug("DocumentTextServiceImpl::findAll");
        List<DocumentText> result = new ArrayList<>();
        Iterable<DocumentText> documentTextIterable = documentTextRepository.findAll();
        documentTextIterable.forEach(result::add);
        return result;
    }

}
