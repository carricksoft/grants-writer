/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;

import scot.carricksoftware.grantswriter.domains.images.BaseImage;
import scot.carricksoftware.grantswriter.domains.text.BaseText;

import java.util.List;

public interface CombinedContentList {

    void addBaseImage(BaseImage image);

    void addBaseText(BaseText text);

    void sort();

    List<Combined> getList();

    void clear();
}
