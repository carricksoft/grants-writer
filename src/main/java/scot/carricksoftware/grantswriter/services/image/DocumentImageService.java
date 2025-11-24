/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;


import scot.carricksoftware.grantswriter.domains.images.DocumentImage;

import java.util.List;

public interface DocumentImageService {

    List<DocumentImage> findAll();
    DocumentImage findById(Long id);
}
