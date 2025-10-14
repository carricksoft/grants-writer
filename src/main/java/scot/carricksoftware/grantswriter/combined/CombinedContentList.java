/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;

import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.text.PersonText;

import java.util.List;

public interface CombinedContentList {

    void addPersonImage(PersonImage image);

    void addPersonText(PersonText text);

    void sort();

    List<Combined> getList();

    void clear();
}
