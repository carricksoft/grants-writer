/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 12:33. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.documenttext;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.domains.text.DocumentText;

import java.util.List;


@Service
public interface DocumentTextService {

    @SuppressWarnings("unused")
    DocumentText findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
DocumentText save(DocumentText documentText);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<DocumentText> getPagedDocumentTexts(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    DocumentTextCommand saveDocumentTextCommand(DocumentTextCommand documentTextCommand);

    @SuppressWarnings("unused")
    List<DocumentText> findAll();
}
