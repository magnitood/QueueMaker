package com.mag.utils;



import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.jar.JarFile;

/**
 * generates datapack for given version (internal work: copies directory from resource folder to a local destination)
 */
public abstract class PackGenerator {

    private static final String DATAPACK_FOLDER_NAME_IN_JAR="Bartering Queue ";
    /**
     * Copies the Datapack from the Resource folder to local location, uses different code for IDE and Jars
     * @param packDestinationFolder Folder name of the directory in String where the pack is to be copied
     * @param version version of the pack, valid values: "1.16.1, 1.16.5"
     */
    public static void generatePack(File packDestinationFolder, String version) throws IOException, URISyntaxException {
        if (!packDestinationFolder.isDirectory()) {
            throw new IllegalArgumentException("Given file is not a folder");
        }
        Optional<JarFile> thisJar = ResourceHelper.jar(PackGenerator.class);
        if (thisJar.isEmpty()) {
            File packSourceFolder = new File(PackGenerator.class.getClassLoader().getResource(DATAPACK_FOLDER_NAME_IN_JAR + version).toURI());
            FileUtils.copyDirectory(packSourceFolder, packDestinationFolder);
        } else {
            ResourceHelper.copyResourceDirectory(thisJar.get(), DATAPACK_FOLDER_NAME_IN_JAR + version, packDestinationFolder);
        }
//        if(resourceUrl.toString().startsWith("jar")){
//            ResourceCopy resourceCopy = new ResourceCopy();
//            String thisrunningjarloation = PackGenerator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
//            Optional<JarFile> thisjar = resourceCopy.jar(PackGenerator.class);
//            File destPack = new File(filename);
//            destPack.mkdir();
//            resourceCopy.copyResourceDirectory(thisjar, "Bartering Queue "+version, destPack);
//        }
//        else{
//            File srcPack = new File(resourceUrl.toURI());
//            FileUtils.copyDirectory(srcPack, new File(filename));
//        }
    }
}
