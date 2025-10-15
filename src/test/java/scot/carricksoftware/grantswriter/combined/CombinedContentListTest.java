/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.images.PersonImage;
import scot.carricksoftware.grantswriter.domains.text.PersonText;

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

        assertEquals(image.getOrder(), combinedContentList.getList().get(0).getOrder());
        assertEquals("image", combinedContentList.getList().get(0).getContentType());
        assertEquals(image.getId(), combinedContentList.getList().get(0).getContentId());
    }

    @Test
    void addPersonTextTest() {
        PersonText text = new PersonText();
        text.setOrder(GetRandomString());
        text.setId(GetRandomLong());

        combinedContentList.addPersonText(text);

        assertEquals(text.getOrder(), combinedContentList.getList().get(0).getOrder());
        assertEquals("text", combinedContentList.getList().get(0).getContentType());
        assertEquals(text.getId(), combinedContentList.getList().get(0).getContentId());
    }

    @Test
    void clearTest() {
        PersonText text = new PersonText();
        text.setOrder(GetRandomString());
        text.setId(GetRandomLong());

        combinedContentList.addPersonText(text);

        assertEquals(1, combinedContentList.getList().size());
        combinedContentList.clear();
        assertEquals(0, combinedContentList.getList().size());
    }

    @Test
    void sortTest() {
        String high = "99";
        String low = "1";
        PersonText text1 = new PersonText();
        text1.setOrder(high);
        text1.setId(GetRandomLong());
        PersonText text2 = new PersonText();
        text2.setOrder(low);
        text2.setId(GetRandomLong());

        combinedContentList.addPersonText(text1);
        combinedContentList.addPersonText(text2);
        combinedContentList.sort();
        assertEquals(low, combinedContentList.getList().get(0).getOrder());
        assertEquals(high, combinedContentList.getList().get(1).getOrder());


    }


}