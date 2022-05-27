package com.mag;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.mag.Utils.ItemList_1_16_1;
import com.mag.Utils.ItemList_1_16_5;
import com.mag.Utils.PrimaryMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class Main{
    static ArrayList<String> items = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) throws IOException{


        System.out.println("Pick Version");
        Main.printVersionMenu();
        switch (input.nextInt()) {
            case 1 -> Main.item_1();
            case 2 -> Main.item_5();
            default -> {
                System.out.println("Invalid Number, using default");
                Main.item_1();
            }
        }
    }
    public static void item_1() throws IOException {
        boolean addMoreItems = true;
        while(addMoreItems){
            Main.printMenu();
            switch (input.nextInt()) {
                case 1 -> {
                    ItemList_1_16_1[] item = ItemList_1_16_1.values();
                    for (int i = 0; i < item.length; i++) {
                        System.out.println(i + 1 + ". " + item[i].display_name);
                    }
                    System.out.println("Enter number corresponding of item you want");
                    int num = input.nextInt();
                    try {
                        items.add(item[num - 1].string);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Wrong Input, ignoring!");
                    }
                }
                case 2 -> {
                    mapper.writerWithDefaultPrettyPrinter().writeValue(new File("piglin_bartering.json"), new PrimaryMapper(items));
                    addMoreItems = false;
                    System.out.println("piglin_bartering.json generated");
                    System.out.println("copy it to BarteringQueue/data/minecraft/loot_tables/gameplay/");
                }
                default -> System.out.println("Are you  perhaps dumb? Select the correct number");
            }
        }
    }
    public static void item_5() throws IOException {
        boolean addMoreItems = true;
        while(addMoreItems){
            Main.printMenu();
            switch (input.nextInt()) {
                case 1 -> {
                    ItemList_1_16_5[] item = ItemList_1_16_5.values();
                    for (int i = 0; i < item.length; i++) {
                        System.out.println(i + 1 + ". " + item[i].display_name);
                    }
                    System.out.println("Enter number corresponding of item you want");
                    int num = input.nextInt();
                    try {
                        items.add(item[num - 1].string);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Wrong Input, ignoring!");
                    }
                }
                case 2 -> {
                    mapper.writerWithDefaultPrettyPrinter().writeValue(new File("piglin_bartering.json"), new PrimaryMapper(items));
                    addMoreItems = false;
                    System.out.println("piglin_bartering.json generated");
                    System.out.println("copy it to BarteringQueue/data/minecraft/loot_tables/gameplay/");
                }
                default -> System.out.println("Are you  perhaps dumb? Select the correct number");
            }
        }
    }
    public static void printVersionMenu(){
        System.out.println("1. 1.16.1");
        System.out.println("2. 1.16.5+");
        System.out.println("Default: 1.16.1");
    }
    public static void printMenu(){
        System.out.println("1. Add Item");
        System.out.println("2. Make Json");
    }
}