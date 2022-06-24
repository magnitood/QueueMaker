package com.mag.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class PackGenerator {//class for generaating copying datapack from resource folder to outside location for the different versions
//can't be instantiated

    /*example use
            PackGenerator.generatePack("/home/mag", "1.16.1");*/
    public static void generatePack(String filepath,String version) throws URISyntaxException, IOException {//copies datapack folder from resource location to a provided path
        FileUtils.copyDirectory(getFilefromResource(version), new File(filepath));
    }
    private static File getFilefromResource(String version) throws URISyntaxException {//converts resource location to file
        String url_1161 = "Bartering Queue 1.16.1";
        String url_1165 = "Bartering Queue 1.16.5";
        String name = (version.equals("1.16.5")) ? url_1165 : url_1161;
        URL resource = PackGenerator.class.getClassLoader().getResource(name);
        File srcPack;
        if (resource != null) {
            srcPack = new File(resource.toURI());
        } else {
            throw new RuntimeException();
        }
        return srcPack;
    }
}
