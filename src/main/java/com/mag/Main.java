package com.mag;


import com.mag.core.*;
import com.mag.utils.PackGenerator;
import com.mag.utils.StringParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
public class Main{
    private static BarteringItems[] barteringItemsArray;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Version version;
    private static final PiglinBarteringJsonGenerator piglinBarteringJsonGenerator = new PiglinBarteringJsonGenerator();
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        setVersionFromUser();
        makeBarteringItemArray();
        displayOptions();
        parseString();
        copyDataPack();
        generateFinalJson();
    }
    public static void makeBarteringItemArray(){
        ArrayList<BarteringItems> barteringItemsArrayList = new ArrayList<>();
        for(int i = 0; i< BarteringItems.values().length; i++){
            if (BarteringItems.values()[i].version.equals(Version.BOTH) || (BarteringItems.values()[i].version.equals(version))){
                barteringItemsArrayList.add(BarteringItems.values()[i]);
            }
        }
        Main.barteringItemsArray = barteringItemsArrayList.toArray(new BarteringItems[barteringItemsArrayList.size()]);
    }
    public static void displayOptions(){
        for (int i =0;i<barteringItemsArray.length;i++){
            System.out.println(i+1+": "+barteringItemsArray[i].display_name);
        }
        System.out.println("Add items with the shown number with the format <item_number>*<count>");
        System.out.println("Put space between each item");
        System.out.println("For example, if you want 10 obsidian trades, 4 ender pearl trades and 3 string trades, you would type:");
    }
    public static void setVersionFromUser() throws IOException, InterruptedException {
        System.out.println("1: 1.16.1");
        System.out.println("2: 1.16.5");
        System.out.println("Default: 1.16.1");
        System.out.println("Enter choice");
        try {
            int choice = Integer.parseInt(br.readLine());
            if (choice == 2) {
                version = Version.VERSION_1165;
            } else if (choice == 1) {
                version = Version.VERSION_1161;
            } else {
                System.out.println("Incorrect Option, try again");
                Thread.sleep(1000);
                setVersionFromUser();
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect Option, try again");
            Thread.sleep(1000);
            setVersionFromUser();
        }
    }
    public static void parseString(){
        try {
            StringParser stringParser = new StringParser(br.readLine());
            for(int i=0;i<stringParser.getTotalItemCount();i++){
                piglinBarteringJsonGenerator.addBarteringItemStack(new BarteringItemStack(barteringItemsArray[stringParser.getIndex(i)-1] , stringParser.getCount(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred, pls try again");
            parseString();
        }
    }
    public static void copyDataPack() throws IOException, URISyntaxException {
        File datapackFolder = new File("Bartering Queue "+version.version_string);
        datapackFolder.mkdir();
        PackGenerator.generatePack(datapackFolder, version);
    }
    public static void generateFinalJson() throws IOException {
        File folder = new File("Bartering Queue "+version.version_string+"/data/minecraft/loot_tables/gameplay/piglin_bartering.json");
        piglinBarteringJsonGenerator.generatePiglinBarteringDotJson(folder);}
}