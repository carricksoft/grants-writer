/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.constants.LatexConstants;


@Component
public class LatexItemizeEndImpl implements LatexItemizeEnd {

    private final LatexBlock latexBlock;

    public LatexItemizeEndImpl(LatexBlock latexBlock) {
        this.latexBlock = latexBlock;
    }

    @Override
    public void write() {
        latexBlock.endRunningBlock(LatexConstants.ITEMIZE);
    }
}
