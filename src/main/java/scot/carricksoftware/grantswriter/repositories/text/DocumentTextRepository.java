/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.repositories.text;

import org.springframework.stereotype.Repository;
import scot.carricksoftware.grantswriter.domains.text.DocumentText;
import scot.carricksoftware.grantswriter.repositories.ReadOnlyRepository;


@SuppressWarnings("unused")
@Repository
public interface DocumentTextRepository extends ReadOnlyRepository<DocumentText, Long> {
    @SuppressWarnings("unused")
    Iterable<DocumentText> findAll();
    DocumentText findById(Long id);
}
