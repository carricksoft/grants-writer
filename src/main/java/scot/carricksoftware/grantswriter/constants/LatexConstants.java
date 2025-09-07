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
    public static final String DOCUMENT_CLASS = "\\documentclass[a4paper,11pt, twoside]{memoir}";
    public static final String DOCUMENT_START = "\\begin{document}";
    public static final String DOCUMENT_END = "\\end{document}";
    @SuppressWarnings("SpellCheckingInspection")
    public static final String LONG_TABLE_END = "\\end{longtable}";
    @SuppressWarnings("SpellCheckingInspection")
    public static final String LONG_TABLE_START = "\\begin{longtable}{";

    @SuppressWarnings("SpellCheckingInspection")
    public static final String USE_PACKAGE_TERM = "\\usepackage{";
    public static final String TERM_END = "}";
    public static final String TABLE_COLUMN_END = "&";
    public static final String TABLE_LINE_END = "\\\\";

}
