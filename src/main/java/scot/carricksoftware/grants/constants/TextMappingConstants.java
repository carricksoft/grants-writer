/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class TextMappingConstants {

    private TextMappingConstants() {
        // to stop checkstyle complaining
    }


    @SuppressWarnings({"unused"})
    public static final String DOCUMENT_TEXT_LIST = "/documentTexts";
    @SuppressWarnings({"unused"})
    public static final String DOCUMENT_TEXT_NEXT = "/documentTexts/next";
    @SuppressWarnings({"unused"})
    public static final String DOCUMENT_TEXT_PREVIOUS = "/documentTexts/prev";
    @SuppressWarnings({"unused"})
    public static final String DOCUMENT_TEXT_REWIND = "/documentTexts/rewind";
    @SuppressWarnings({"unused"})
    public static final String DOCUMENT_TEXT_FF = "/documentTexts/ff";
    @SuppressWarnings({"unused"})
    public static final String DOCUMENT_TEXT_NEW = "/documentText/new";
    @SuppressWarnings({"unused"})
    public static final String DOCUMENT_TEXT = "/documentText";
    @SuppressWarnings({"unused"})
    public static final String DOCUMENT_TEXT_SHOW = "/documentText/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String DOCUMENT_TEXT_DELETE = "/documentTexts/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String DOCUMENT_TEXT_EDIT = "documentText/{id}/edit";


  
}






