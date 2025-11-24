/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 12:33. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.services.text;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grantswriter.domains.text.DocumentText;

import java.util.List;


@Service
public interface DocumentTextService extends TextService {

    @SuppressWarnings("unused")
    List<DocumentText> findAll();

    DocumentText findById(Long id);
}
