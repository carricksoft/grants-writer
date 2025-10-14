/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;

import scot.carricksoftware.grantswriter.domains.images.Image;

import java.util.List;

public class CombinedContentListImpl implements CombinedContentList {

    private List<Combined> combinedList;

    @SuppressWarnings("EmptyMethod")
    @Override
    public void addPersonImage(Image image) {

    }

    @SuppressWarnings("EmptyMethod")
    @Override
    public void addPersonText(List<Image> images) {

    }

    @Override
    public void sort() {

    }

    @Override
    public List<Combined> getList() {
        return this.combinedList;
    }

    @Override
    public void clear() {

    }


}
