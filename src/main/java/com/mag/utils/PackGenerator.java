package com.mag.utils;



import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.jar.JarFile;

/**
 * generates datapack for given version (internal work: copies directory from resource folder to a local destination)
 */
public abstract class PackGenerator {
    /**
     * Copies the Datapack from the Resource folder to local location, uses different code for IDE and Jars
     * @param filename name of the directory in String where the pack is to be copied
     * @param version version of the pack, valid values: "1.16.1, 1.16.5"
     */
    public static void generatePack(String filename, String version) throws IOException, URISyntaxException {
        URL resourceUrl = PackGenerator.class.getClassLoader().getResource("Bartering Queue "+version);
        if(resourceUrl.toString().startsWith("jar")){
            ResourceCopy resourceCopy = new ResourceCopy();
            String thisrunningjarloation = PackGenerator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            JarFile thisjar = new JarFile(thisrunningjarloation);
            File destPack = new File(filename);
            destPack.mkdir();
            resourceCopy.copyResourceDirectory(thisjar, "Bartering Queue "+version, destPack);
        }
        else{
            File srcPack = new File(resourceUrl.toURI());
            FileUtils.copyDirectory(srcPack, new File(filename));
        }
    }
}
