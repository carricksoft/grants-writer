/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.combined;

public class CombinedImpl implements Combined {

    private String contentType;
    private String order;
    private Long contentId;

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getOrder() {
        return order;
    }

    @Override
    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public Long getContentId() {
        return contentId;
    }

    @Override
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
}
