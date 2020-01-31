package com.codegym.task.task16.task1631;

import com.codegym.task.task16.task1631.common.*;


public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes s){
        if(s==null) throw new IllegalArgumentException("Unknown image type");
        if(s.equals(ImageTypes.JPG)) return new JpgReader();
        if(s.equals(ImageTypes.BMP)) return new BmpReader();
        if(s.equals(ImageTypes.PNG)) return new PngReader();
        throw new IllegalArgumentException("Unknown image type");
    }
}
