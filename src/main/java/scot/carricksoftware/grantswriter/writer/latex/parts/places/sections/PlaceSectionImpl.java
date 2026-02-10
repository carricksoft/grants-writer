/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.sections;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.ClearExistingTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.GatherPeopleTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.headers.PlaceSectionHeader;

@Component
public class PlaceSectionImpl implements PlaceSection {

    private final PlaceSectionHeader placeSectionHeader;
//    private final PersonSubSectionTimeLineWriter personSubSectionTimeLineWriter;
 //   private final PersonSubSectionReferencesWriter personSubSectionReferencesWriter;
    private final ClearExistingTimeLineData clearExistingTimeLineData;
    private final GatherPeopleTimeLineData gatherPeopleTimeLineData;

    public PlaceSectionImpl(PlaceSectionHeader placeSectionHeader, ClearExistingTimeLineData clearExistingTimeLineData, GatherPeopleTimeLineData gatherPeopleTimeLineData) {
        this.placeSectionHeader = placeSectionHeader;
        this.clearExistingTimeLineData = clearExistingTimeLineData;
        this.gatherPeopleTimeLineData = gatherPeopleTimeLineData;
    }

    @Override
    public void write(Place place) {
        placeSectionHeader.write(place);
      //  placeSectionContentsWriter.write(place);
        clearExistingTimeLineData.clear();
     //   gatherTimeLineData.gather(place);
     //   placeSubSectionTimeLineWriter.write();
     //   placeSubSectionReferencesWriter.write();
    }
}
