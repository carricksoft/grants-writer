/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.constants;

import org.springframework.stereotype.Component;

@Component
public class LatexLevels {

    private LatexLevels() {
        // to stop checkstyle complaining
    }

    public static final Integer LATEX_BOOK  = -2;
    public static final Integer LATEX_PART  = -1;
    public static final Integer LATEX_CHAPTER  = 0;
    public static final Integer LATEX_SECTION  = 1;
    public static final Integer LATEX_SUBSECTION  = 2;
    public static final Integer LATEX_SUB_SUBSECTION  = 3;
    public static final Integer LATEX_PARAGRAPH  = 4;
    public static final Integer LATEX_SUBPARAGRAPH = 5;

}
