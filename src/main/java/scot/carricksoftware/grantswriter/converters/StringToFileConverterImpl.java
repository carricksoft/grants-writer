/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.converters;

import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.DatatypeConverter;

@Component
public class StringToFileConverterImpl implements StringToFileConverter {

    @Override
    public void convert(String string, String fileName) {
        byte[] data = DatatypeConverter.parseBase64Binary(string);
        File file = new File(fileName);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
