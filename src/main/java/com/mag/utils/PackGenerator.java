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
     *
     * @param filename name of the directory in String where the pack is to be copied
     * @param version version of the pack, valid values: "1.16.1, 1.16.5"
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void generatePack(String filename, String version) throws IOException, URISyntaxException {
        URL resourceUrl = PackGenerator.class.getClassLoader().getResource("Bartering Queue "+version);
        System.out.println(resourceUrl);
        if(resourceUrl.toString().startsWith("jar")){
            ResourceCopy resourceCopy = new ResourceCopy();
            String thisrunningjarloation = PackGenerator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            System.out.println(thisrunningjarloation);
            JarFile thisjar = new JarFile(thisrunningjarloation);
            System.out.println(thisjar);
            File destPack = new File(filename);
            destPack.mkdir();
            resourceCopy.copyResourceDirectory(thisjar, "Bartering Queue "+version, destPack);
            System.out.println("hopefully file is made");
        }
        else{
            File srcPack = new File(resourceUrl.toURI());
            FileUtils.copyDirectoryToDirectory(srcPack, new File(filename));
            System.out.println("directory copied");
        }
    }
}
