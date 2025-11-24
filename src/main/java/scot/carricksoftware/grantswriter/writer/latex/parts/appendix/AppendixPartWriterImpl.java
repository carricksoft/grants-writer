/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentType;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.image.AppendixImageService;
import scot.carricksoftware.grantswriter.services.text.AppendixTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseImage;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers.AppendixPartHeader;

import java.util.List;

@Component
public class AppendixPartWriterImpl implements AppendixPartWriter {

    private static final Logger logger = LogManager.getLogger(AppendixPartWriterImpl.class);

    private final AppendixPartHeader appendixPartHeader;
    private final WriteBaseText writeBaseText;
    private final WriteBaseImage writeBaseImage;
    private final AppendixTextService appendixTextService;
    private final AppendixImageService appendixImageService;
    private final CombinedService combinedService;

    public AppendixPartWriterImpl(AppendixPartHeader appendixPartHeader,
                                  WriteBaseText writeBaseText,
                                  WriteBaseImage writeBaseImage,
                                  AppendixTextService appendixTextService,
                                  AppendixImageService appendixImageService,
                                  CombinedService combinedService) {
        this.appendixPartHeader = appendixPartHeader;
        this.writeBaseText = writeBaseText;
        this.writeBaseImage = writeBaseImage;
        this.appendixTextService = appendixTextService;
        this.appendixImageService = appendixImageService;
        this.combinedService = combinedService;
    }

    public void write() {
        logger.debug("AppendixPartsImpl::write()");
        appendixPartHeader.write();

         List<Combined> combinedList = combinedService.getAppendixContent().getList();

         for (Combined combined : combinedList) {
            if (combined.getContentType().equals(CombinedContentType.TEXT.label)) {
                writeBaseText.write(appendixTextService.findById(combined.getContentId()));
            } else {
                if (combined.getContentType().equals(CombinedContentType.IMAGE.label)) {
                    writeBaseImage.write(appendixImageService.findById(combined.getContentId()));
                }
            }
        }

    }

}
