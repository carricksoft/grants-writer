/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.text;


import scot.carricksoftware.grantswriter.domains.text.PlaceText;

import java.util.List;

public interface PlaceTextService {

    PlaceText findById(Long id);

    List<PlaceText> findAll();

}
