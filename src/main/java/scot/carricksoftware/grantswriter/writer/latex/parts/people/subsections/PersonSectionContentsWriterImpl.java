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

import java.util.List;

@Component
public class PersonSectionContentsWriterImpl implements PersonSectionContentsWriter {

    private static final Logger logger = LogManager.getLogger(PersonSectionContentsWriterImpl.class);

    private final PersonTextService personTextService;

    private final FileWriter fileWriter;

    public PersonSectionContentsWriterImpl(PersonTextService personTextService, FileWriter fileWriter) {
        this.personTextService = personTextService;
        this.fileWriter = fileWriter;
    }


    @Override
    public void write(Person person) {
        logger.info("PersonSectionContentsWriterImpl.write()");
        List<PersonText> contents = personTextService.findAllByPerson(person);
        if (!contents.isEmpty()) {
            for (PersonText personText : contents) {
                writeContent (personText);
            }
        }
    }

    private void writeContent(PersonText personText) {
        logger.info("PersonSectionContentsWriterImpl.writeContent()");
        fileWriter.writeLine(personText.getContent());
    }
}
