/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.parts.appendix.AppendixPartWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.document.DocumentPartWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.people.PeoplePartWriter;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.PlacesPartWriter;

@Component
public class PartsWriterImpl implements PartsWriter {

    private static final Logger logger = LogManager.getLogger(PartsWriterImpl.class);

    private final PeoplePartWriter peoplePartWriter;
    private final PlacesPartWriter placesPartWriter;
    private final AppendixPartWriter appendixPartWriter;
    private final DocumentPartWriter documentPartWriter;

    public PartsWriterImpl(PeoplePartWriter peoplePartWriter,
                           PlacesPartWriter placesPartWriter,
                           AppendixPartWriter appendixPartWriter,
                           DocumentPartWriter documentPartWriter) {
        this.peoplePartWriter = peoplePartWriter;
        this.placesPartWriter = placesPartWriter;
        this.appendixPartWriter = appendixPartWriter;
        this.documentPartWriter = documentPartWriter;
    }

    @Override
    public void write() {
        logger.info("WritePartsImpl.write()");
        documentPartWriter.write();
        peoplePartWriter.write();
        placesPartWriter.write();
        appendixPartWriter.write();
    }
}
