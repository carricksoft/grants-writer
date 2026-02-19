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
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class CombinedPlaceServiceSortTest {

    private CombinedPlaceService service;

    @Mock
    PlaceTextRepository placeTextRepositoryMock;

    @Mock
    PlaceImageRepository placeImageRepositoryMock;

    private List<PlaceText> placeTextList;
    private List<PlaceImage> placeImageList;
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
    void sortingWorksTest() {
        String highOrder = "99";
        placeText.setOrder(highOrder);
        placeText.setId(Id);
        placeTextList.add(placeText);
        when(placeTextRepositoryMock.findAllByPlace(place)).thenReturn(placeTextList);

        String lowOrder = "1";
        placeImage.setOrder(lowOrder);
        placeImage.setId(Id);
        placeImageList.add(placeImage);
        when(placeImageRepositoryMock.findAllByPlace(place)).thenReturn(placeImageList);
        CombinedContentList combinedContentList = service.getPlaceContent(place);

        assertEquals(lowOrder, combinedContentList.getList().get(0).getOrder());
        assertEquals(highOrder, combinedContentList.getList().get(1).getOrder());
    }


}