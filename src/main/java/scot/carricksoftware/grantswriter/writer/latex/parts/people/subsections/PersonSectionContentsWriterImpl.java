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
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.services.combined.CombinedService;
import scot.carricksoftware.grantswriter.services.text.PersonTextService;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexDivisionHeader;
import scot.carricksoftware.grantswriter.writer.latex.WriteBaseText;

import java.util.List;

@Component
public class PersonSectionContentsWriterImpl implements PersonSectionContentsWriter {

    private static final Logger logger = LogManager.getLogger(PersonSectionContentsWriterImpl.class);

    private final PersonTextService personTextService;

    private final CombinedService combinedService;

    private final FileWriter fileWriter;

    private final LatexDivisionHeader latexDivisionHeader;

    private final WriteBaseText writeBaseText;

    public PersonSectionContentsWriterImpl(
            PersonTextService personTextService,
            CombinedService combinedService,
            FileWriter fileWriter,
            LatexDivisionHeader latexDivisionHeader, WriteBaseText writeBaseText) {
        this.personTextService = personTextService;
        this.combinedService = combinedService;
        this.fileWriter = fileWriter;
        this.latexDivisionHeader = latexDivisionHeader;
        this.writeBaseText = writeBaseText;
    }

    @Override
    public void write(Person person) {
        logger.info("PersonSectionContentsWriterImpl.write()");
        List<Combined> combinedList = combinedService.getPersonContent(person).getList();
        for (Combined combined : combinedList) {
            if (combined.getContentType().equals(CombinedContentType.TEXT.label)) {
                writeBaseText.write(personTextService.findById(combined.getContentId()));
            }
       }
    }

    private void writeTextContent(PersonText personText) {
        logger.info("PersonSectionContentsWriterImpl.writeTextContent()");
        fileWriter.writeLine(personText.getContent());
    }

    private void writeTextHeading(PersonText personText){
        logger.info("PersonSectionContentsWriterImpl.writeTextHeading()");
        if (personText.getHeading() != null) {
            latexDivisionHeader.write(Integer.parseInt(personText.getLevel()), personText.getHeading());
        }
    }

    private void writePersonText(Long id) {
        logger.info("PersonSectionContentsWriterImpl.writePersonText()");
        PersonText newPersonText = personTextService.findById(id);
        writeBaseText.write(newPersonText);
    }
}
