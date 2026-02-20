/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.sections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionReferencesWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionTimeLineWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.ClearExistingTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.headers.PlaceSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.PlaceSectionContentsWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.GatherPlaceTimeLineData;

import static org.mockito.Mockito.inOrder;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class PlaceSectionTest {

    private PlaceSection placeSection;

    @Mock
    PlaceSectionHeader placeSectionHeaderMock;
    @Mock
    PlaceSectionContentsWriter placeSectionContentsWriterMock;
    @Mock
    ClearExistingTimeLineData clearExistingTimeLineDataMock;
    @Mock
    GatherPlaceTimeLineData gatherPlaceTimeLineDataMock;
    @Mock
    PersonSubSectionTimeLineWriter personSubSectionTimeLineWriterMock;
    @Mock
    PersonSubSectionReferencesWriter personSubSectionReferencesWriterMock;

    @BeforeEach
    public void setUp() {
        placeSection = new PlaceSectionImpl(
                placeSectionHeaderMock,
                personSubSectionTimeLineWriterMock,
                personSubSectionReferencesWriterMock,
                clearExistingTimeLineDataMock,
                gatherPlaceTimeLineDataMock,
                placeSectionContentsWriterMock);
    }

    @Test
    public void writeTest() {
        Place place = GetRandomPlace();
        InOrder inorder = inOrder(placeSectionHeaderMock,
                placeSectionContentsWriterMock,
                clearExistingTimeLineDataMock,
                gatherPlaceTimeLineDataMock,
                personSubSectionTimeLineWriterMock,
                personSubSectionReferencesWriterMock);

        placeSection.write(place);
        inorder.verify(placeSectionHeaderMock).write(place);
        inorder.verify(placeSectionContentsWriterMock).write(place);
        inorder.verify(clearExistingTimeLineDataMock).clear();
        inorder.verify(gatherPlaceTimeLineDataMock).gather(place);
        inorder.verify(personSubSectionTimeLineWriterMock).write();
        inorder.verify(personSubSectionReferencesWriterMock).write();
    }

}