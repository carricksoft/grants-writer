/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentType;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseImage;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;

import java.util.List;

@Component
public class PlaceSectionContentsWriterImpl implements PlaceSectionContentsWriter {

    private static final Logger logger = LogManager.getLogger(PlaceSectionContentsWriterImpl.class);

 //   private final PersonTextService personTextService;
 //   private final PersonImageService personImageService;
    private final CombinedService combinedService;
    private final WriteBaseText writeBaseText;
    private final WriteBaseImage writeBaseImage;

    public PlaceSectionContentsWriterImpl(CombinedService combinedService, WriteBaseText writeBaseText, WriteBaseImage writeBaseImage) {
        this.combinedService = combinedService;
        this.writeBaseText = writeBaseText;
        this.writeBaseImage = writeBaseImage;
    }

    @Override
    public void write(Place place) {
       logger.info("PersonSectionContentsWriterImpl.write()");
        List<Combined> combinedList = combinedService.getPlaceContent(place).getList();
        for (Combined combined : combinedList) {
            if (combined.getContentType().equals(CombinedContentType.TEXT.label)) {
  //              writeBaseText.write(placeTextService.findById(combined.getContentId()));
            }
            else {
                if (combined.getContentType().equals(CombinedContentType.IMAGE.label)) {
   //                 writeBaseImage.write(placeImageService.findById(combined.getContentId()));
                }
            }
       }
    }

}
