/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.FileWriter;

@Component
public class LatexBlockImpl implements LatexBlock {

    private final FileWriter fileWriter;

    public LatexBlockImpl(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void begin(String blockName, String options) {
        String text = ("\\begin") + "{" + blockName + "}";
        if (options != null && !options.isEmpty()) {
            text += "[" + options + "]";
        }
        text += "{";
        fileWriter.writeLine(text);
    }

    @Override
    public void end(String blockName) {
        fileWriter.writeLine( "}" + "\\end" + blockName + "}");
    }
}
