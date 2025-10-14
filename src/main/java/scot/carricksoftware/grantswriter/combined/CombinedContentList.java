/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;

import scot.carricksoftware.grantswriter.domains.images.Image;

import java.util.List;

public interface CombinedContentList {
    @SuppressWarnings("EmptyMethod")
    void addPersonImage(Image image);

    @SuppressWarnings("EmptyMethod")
    void addPersonText(List<Image> images);

    @SuppressWarnings("EmptyMethod")
    void sort();

    List<Combined> getList();

    @SuppressWarnings("EmptyMethod")
    void clear();
}
