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

    public static final String PERSON_TEXT_LIST = "/personTexts";
    @SuppressWarnings({"unused"})
    public static final String PERSON_TEXT_NEXT = "/personTexts/next";
    @SuppressWarnings({"unused"})
    public static final String PERSON_TEXT_PREVIOUS = "/personTexts/prev";
    @SuppressWarnings({"unused"})
    public static final String PERSON_TEXT_REWIND = "/personTexts/rewind";
    @SuppressWarnings({"unused"})
    public static final String PERSON_TEXT_FF = "/personTexts/ff";
    @SuppressWarnings({"unused"})
    public static final String PERSON_TEXT_NEW = "/personText/new";
    @SuppressWarnings({"unused"})
    public static final String PERSON_TEXT = "/personText";
    @SuppressWarnings({"unused"})
    public static final String PERSON_TEXT_SHOW = "/personText/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String PERSON_TEXT_DELETE = "/personTexts/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String PERSON_TEXT_EDIT = "personText/{id}/edit";

    public static final String PLACE_TEXT_LIST = "/placeTexts";
    @SuppressWarnings({"unused"})
    public static final String PLACE_TEXT_NEXT = "/placeTexts/next";
    @SuppressWarnings({"unused"})
    public static final String PLACE_TEXT_PREVIOUS = "/placeTexts/prev";
    @SuppressWarnings({"unused"})
    public static final String PLACE_TEXT_REWIND = "/placeTexts/rewind";
    @SuppressWarnings({"unused"})
    public static final String PLACE_TEXT_FF = "/placeTexts/ff";
    @SuppressWarnings({"unused"})
    public static final String PLACE_TEXT_NEW = "/placeText/new";
    @SuppressWarnings({"unused"})
    public static final String PLACE_TEXT = "/placeText";
    @SuppressWarnings({"unused"})
    public static final String PLACE_TEXT_SHOW = "/placeText/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String PLACE_TEXT_DELETE = "/placeTexts/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String PLACE_TEXT_EDIT = "placeText/{id}/edit";
    
}






