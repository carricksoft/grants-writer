/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.text.PersonText;
import scot.carricksoftware.grantswriter.services.text.PersonTextService;
import scot.carricksoftware.grantswriter.writer.FileWriter;
import scot.carricksoftware.grantswriter.writer.latex.LatexDivisionHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers.PersonListSortByOrder;

import java.util.List;

@Component
public class PersonSectionContentsWriterImpl implements PersonSectionContentsWriter {

    private static final Logger logger = LogManager.getLogger(PersonSectionContentsWriterImpl.class);

    private final PersonTextService personTextService;

    private final FileWriter fileWriter;

    private final LatexDivisionHeader latexDivisionHeader;

    private final PersonListSortByOrder personListSortByOrder;

    public PersonSectionContentsWriterImpl(PersonTextService personTextService, FileWriter fileWriter, LatexDivisionHeader latexDivisionHeader, PersonListSortByOrder personListSortByOrder) {
        this.personTextService = personTextService;
        this.fileWriter = fileWriter;
        this.latexDivisionHeader = latexDivisionHeader;
        this.personListSortByOrder = personListSortByOrder;
    }

    @Override
    public void write(Person person) {
        logger.info("PersonSectionContentsWriterImpl.write()");
        List<PersonText> contents = personTextService.findAllByPerson(person);
        if (!contents.isEmpty()) {
            personListSortByOrder.sort(contents);
            for (PersonText personText : contents) {
                writePersonText(personText.getId());
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
        PersonText personText = personTextService.findById(id);
        writeTextHeading(personText);
        writeTextContent (personText);
    }
}
