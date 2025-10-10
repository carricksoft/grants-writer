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
        StringBuilder text = new StringBuilder();
        text.append("\\begin{");
        text.append(blockName);
        text.append("}");
        if (options != null && !options.isEmpty()) {
            text.append("[");
            text.append(options);
            text.append("]");
        }
        text.append("{");
        fileWriter.writeLine(text.toString());

    }

    @Override
    public void end(String blockName) {
        String text = "}" +
                "\\end" +
                blockName +
                "}";
        fileWriter.writeLine(text);
    }
}
