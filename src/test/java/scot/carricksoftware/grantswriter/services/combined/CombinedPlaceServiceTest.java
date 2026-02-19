/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.combined;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.domains.images.PlaceImage;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.domains.text.PlaceText;
import scot.carricksoftware.grantswriter.repositories.place.PlaceImageRepository;
import scot.carricksoftware.grantswriter.repositories.text.PlaceTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class CombinedPlaceServiceTest {

    private CombinedPlaceService service;

    @Mock
    PlaceTextRepository placeTextRepositoryMock;

    @Mock
    PlaceImageRepository placeImageRepositoryMock;

    private List<PlaceText> placeTextList;
    private List<PlaceImage> placeImageList;
    private final String order = GetRandomString();
    private final Long Id = GetRandomLong();
    private final Place place = GetRandomPlace();
    private final PlaceText placeText = new PlaceText();
    private final PlaceImage placeImage = new PlaceImage();

    @BeforeEach
    void setUp() {
        service = new CombinedPlaceServiceImpl(placeTextRepositoryMock, placeImageRepositoryMock);
        placeTextList = new ArrayList<>();
        placeImageList = new ArrayList<>();

    }

    @Test
    void placeTextsAreCorrectlyAddedTest() {
        placeText.setOrder(order);
        placeText.setId(Id);
        placeTextList.add(placeText);
        when(placeTextRepositoryMock.findAllByPlace(place)).thenReturn(placeTextList);
        CombinedContentList combinedContentList = service.getPlaceContent(place);

        Combined combined = combinedContentList.getList().get(0);
        assertEquals("text", combined.getContentType());
        assertEquals(order, combined.getOrder());
        assertEquals(Id, combined.getContentId());
    }

    @Test
    void placeImagesAreCorrectlyAddedTest() {
        placeImage.setOrder(order);
        placeImage.setId(Id);
        placeImageList.add(placeImage);
        when(placeImageRepositoryMock.findAllByPlace(place)).thenReturn(placeImageList);
        CombinedContentList combinedContentList = service.getPlaceContent(place);

        Combined combined = combinedContentList.getList().get(0);
        assertEquals("image", combined.getContentType());
        assertEquals(order, combined.getOrder());
        assertEquals(Id, combined.getContentId());
    }


}