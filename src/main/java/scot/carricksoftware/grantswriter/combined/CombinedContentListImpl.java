/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;

import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.text.PersonText;

import java.util.ArrayList;
import java.util.List;

public class CombinedContentListImpl implements CombinedContentList {

    private final List<Combined> combinedList = new ArrayList<>();

    @Override
    public void addPersonImage(PersonImage image) {
        Combined combined = new CombinedImpl();
        combined.setOrder(image.getOrder());
        combined.setContentId(image.getId());
        combined.setContentType(CombinedContentType.IMAGE.label);
        combinedList.add(combined);
    }

    @Override
    public void addPersonText(PersonText text) {
        Combined combined = new CombinedImpl();
        combined.setOrder(text.getOrder());
        combined.setContentId(text.getId());
        combined.setContentType(CombinedContentType.TEXT.label);
        combinedList.add(combined);
    }

    @Override
    public void sort() {
        // override the compare() method
        combinedList.sort((s1, s2) -> {
            int o1 = Integer.parseInt(s1.getOrder());
            int o2 = Integer.parseInt(s2.getOrder());
            return Integer.compare(o1, o2);
        });
    }

    @Override
    public List<Combined> getList() {
        return this.combinedList;
    }

    @Override
    public void clear() {
        combinedList.clear();
    }

}
