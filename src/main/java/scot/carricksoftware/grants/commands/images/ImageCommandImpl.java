/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:59. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import org.springframework.stereotype.Component;

@Component
public class ImageCommandImpl implements ImageCommand{

    Long Id;

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }
}
