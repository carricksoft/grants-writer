/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;

@Component
public class LatexItemizeStartImpl implements LatexItemizeStart {

    private static final Logger logger = LogManager.getLogger(LatexItemizeStartImpl.class);

    private final LatexBlock latexBlock;

    public LatexItemizeStartImpl(LatexBlock latexBlock) {
        this.latexBlock = latexBlock;
    }

    @Override
    public void write() {
        logger.info("LatexItemiseStartImpl.write()");
        latexBlock.beginRunningBlock(LatexConstants.ITEMIZE, "");
    }
}
