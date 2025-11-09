/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;


import scot.carricksoftware.grantswriter.domains.images.AppendixImage;

import java.util.List;

public interface AppendixImageService {
    List<AppendixImage> findAll();
    AppendixImage findById(Long id);
}
