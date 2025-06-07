/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.constants;

import org.springframework.stereotype.Component;

@Component
public class LatexConstants {

    private LatexConstants() {
        // to stop checkstyle complaining
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static final String DOCUMENT_CLASS = "\\documentclass[a4paper,11pt]{memoir}";
    public static final String DOCUMENT_START = "\\begin{document}";
    public static final String DOCUMENT_END = "\\end{document}";

    public static final String PART_TERM = "\\part{";
    public static final String TERM_END = "}";

}
