/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;

public interface Combined {
    String getContentType();

    void setContentType(String contentType);

    String getOrder();

    void setOrder(String order);

    Long getContentId();

    void setContentId(Long contentId);
}
