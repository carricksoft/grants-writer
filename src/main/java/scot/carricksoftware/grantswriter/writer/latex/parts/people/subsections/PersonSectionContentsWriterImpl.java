/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.combined.Combined;
import scot.carricksoftware.grantswriter.combined.CombinedContentType;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.image.PersonImageService;
import scot.carricksoftware.grantswriter.services.text.PersonTextService;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseImage;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;

import java.util.List;

@Component
public class PersonSectionContentsWriterImpl implements PersonSectionContentsWriter {

    private static final Logger logger = LogManager.getLogger(PersonSectionContentsWriterImpl.class);

    private final PersonTextService personTextService;
    private final PersonImageService personImageService;
    private final CombinedService combinedService;
    private final WriteBaseText writeBaseText;
    private final WriteBaseImage writeBaseImage;

    public PersonSectionContentsWriterImpl(
            PersonTextService personTextService,
            PersonImageService personImageService,
            CombinedService combinedService,
            WriteBaseText writeBaseText,
            WriteBaseImage writeBaseImage) {
        this.personTextService = personTextService;
        this.personImageService = personImageService;
        this.combinedService = combinedService;
        this.writeBaseText = writeBaseText;
        this.writeBaseImage = writeBaseImage;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void write(Person person) {
        logger.info("PersonSectionContentsWriterImpl.write("+ person.toString()+ ")");
        List<Combined> combinedList = combinedService.getPersonContent(person).getList();
        for (Combined combined : combinedList) {
            if (combined.getContentType().equals(CombinedContentType.TEXT.label)) {
                writeBaseText.write(personTextService.findById(combined.getContentId()));
            }
            else {
                if (combined.getContentType().equals(CombinedContentType.IMAGE.label)) {
                    writeBaseImage.write(personImageService.findById(combined.getContentId()));
                }
            }
       }
    }

}
