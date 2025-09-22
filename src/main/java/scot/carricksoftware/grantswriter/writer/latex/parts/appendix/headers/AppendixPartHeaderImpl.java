/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.appendix.headers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grantswriter.writer.latex.LatexPartHeader;

@Component
public class AppendixPartHeaderImpl implements AppendixPartHeader {

    private static final Logger logger = LogManager.getLogger(AppendixPartHeaderImpl.class);

    private final LatexPartHeader latexPartHeader;

    public AppendixPartHeaderImpl(LatexPartHeader latexPartHeader) {
        this.latexPartHeader = latexPartHeader;
    }

    @Override
    public void write() {
        logger.debug("AppendixPartHeaderImpl::write");
        latexPartHeader.write("Appendix");
    }
}
