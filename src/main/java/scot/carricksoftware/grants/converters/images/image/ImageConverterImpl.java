/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.image;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.commands.images.ImageCommandImpl;
import scot.carricksoftware.grants.domains.images.Image;

@Component
public class ImageConverterImpl implements ImageConverter {

    @Override
    public ImageCommand convert(Image source) {
        ImageCommand target = new ImageCommandImpl();
        target.setId(source.getId());
        return target;
    }
}
