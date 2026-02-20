/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentList;
import scot.carricksoftware.grantswriter.combined.CombinedImpl;
import scot.carricksoftware.grantswriter.domains.images.PlaceImage;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.domains.text.PlaceText;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.image.PlaceImageService;
import scot.carricksoftware.grantswriter.services.text.PlaceTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseImage;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class PlaceSectionContentsWriterTest {

    private PlaceSectionContentsWriter placeSectionContentsWriter;

    @Mock
    private PlaceTextService placeTextServiceMock;
    @Mock
    private PlaceImageService placeImageServiceMock;
    @Mock
    private CombinedService combinedServiceMock;
    @Mock
    private WriteBaseText writeBaseTextMock;
    @Mock
    private WriteBaseImage writeBaseImageMock;

    @Mock
    private CombinedContentList combinedContentListMock;

    private final List<Combined> combinedList = new ArrayList<>();

    private Combined combined;

    private Place place;

    @BeforeEach
    void setUp() {
        placeSectionContentsWriter = new PlaceSectionContentsWriterImpl(
                placeImageServiceMock,
                combinedServiceMock,
                writeBaseTextMock,
                writeBaseImageMock,
                placeTextServiceMock);
        combined = new CombinedImpl();
        place = GetRandomPlace();
        when(combinedServiceMock.getPlaceContent(place)).thenReturn(combinedContentListMock);
    }

    @Test
    void textsAreCorrectlyRoutedTest() {
        combined.setContentType("text");
        combinedList.add(combined);
        PlaceText placeText = new PlaceText();
        when(combinedContentListMock.getList()).thenReturn(combinedList);
        when(placeTextServiceMock.findById(any())).thenReturn(placeText);

        placeSectionContentsWriter.write(place);
        verify(writeBaseTextMock).write(placeText);
    }

    @Test
    void imagesAreCorrectlyRoutedTest() {
        combined.setContentType("image");
        combinedList.add(combined);
        PlaceImage placeImage = new PlaceImage();
        when(combinedContentListMock.getList()).thenReturn(combinedList);
        when(placeImageServiceMock.findById(any())).thenReturn(placeImage);

        placeSectionContentsWriter.write(place);
        verify(writeBaseImageMock).write(placeImage);
    }
}