/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;


import scot.carricksoftware.grantswriter.domains.images.AppendixImage;

import java.util.List;

public interface AppendixImageService {
    @SuppressWarnings("unused")
    List<AppendixImage> findAll();
    @SuppressWarnings("unused")
    AppendixImage findById(Long id);
}
