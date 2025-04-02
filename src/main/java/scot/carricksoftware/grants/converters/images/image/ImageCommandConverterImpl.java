/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.image;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.domains.images.Image;

@Component
public class ImageCommandConverterImpl implements ImageCommandConverter {

    @Override
    public Image convert(@NotNull ImageCommand source) {
        Image target = new Image();
        target.setId(source.getId());
        return target;
    }


}
