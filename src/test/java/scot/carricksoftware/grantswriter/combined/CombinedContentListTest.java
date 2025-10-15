/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.images.PersonImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

class CombinedContentListTest {

    private CombinedContentList combinedContentList;

    @BeforeEach
    void setUp() {
        combinedContentList = new CombinedContentListImpl();
    }

    @Test
    void addPersonImageTest() {
        PersonImage image = new PersonImage();
        image.setOrder(GetRandomString());
        image.setId(GetRandomLong());

        combinedContentList.addPersonImage(image);

        assertEquals(image.getOrder(), combinedContentList.getList().get(0).getOrder(), image.getOrder());
        assertEquals("image", combinedContentList.getList().get(0).getContentType());
        assertEquals(image.getId(), combinedContentList.getList().get(0).getContentId());
    }
}