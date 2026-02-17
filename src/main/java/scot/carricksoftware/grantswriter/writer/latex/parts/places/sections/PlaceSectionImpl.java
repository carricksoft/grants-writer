/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.sections;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionReferencesWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.PersonSubSectionTimeLineWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.ClearExistingTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.GatherPeopleTimeLineData;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.headers.PlaceSectionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.PlaceSectionContentsWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.GatherPlaceTimeLineData;

@Component
public class PlaceSectionImpl implements PlaceSection {

    private final PlaceSectionHeader placeSectionHeader;
    private final PersonSubSectionTimeLineWriter personSubSectionTimeLineWriter;
      private final PersonSubSectionReferencesWriter personSubSectionReferencesWriter;
    private final ClearExistingTimeLineData clearExistingTimeLineData;
    private final GatherPlaceTimeLineData gatherPlaceTimeLineData;
    private final PlaceSectionContentsWriter placeSectionContentsWriter;

    public PlaceSectionImpl(PlaceSectionHeader placeSectionHeader, PersonSubSectionTimeLineWriter personSubSectionTimeLineWriter, PersonSubSectionReferencesWriter personSubSectionReferencesWriter,
                            ClearExistingTimeLineData clearExistingTimeLineData,
                            GatherPlaceTimeLineData gatherPlaceTimeLineData,
                            PlaceSectionContentsWriter placeSectionContentsWriter) {
        this.placeSectionHeader = placeSectionHeader;
        this.personSubSectionTimeLineWriter = personSubSectionTimeLineWriter;
        this.personSubSectionReferencesWriter = personSubSectionReferencesWriter;
        this.clearExistingTimeLineData = clearExistingTimeLineData;
        this.gatherPlaceTimeLineData = gatherPlaceTimeLineData;
        this.placeSectionContentsWriter = placeSectionContentsWriter;
    }

    @Override
    public void write(Place place) {
        placeSectionHeader.write(place);
        placeSectionContentsWriter.write(place);
        clearExistingTimeLineData.clear();
        gatherPlaceTimeLineData.gather(place);
        personSubSectionTimeLineWriter.write();
        personSubSectionReferencesWriter.write();
    }
}
