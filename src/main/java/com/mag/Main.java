package com.mag;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.mag.core.ItemList_1_16_1;
import com.mag.core.ItemList_1_16_5;
import com.mag.core.PrimaryMapper;
import com.mag.utils.StringParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


class Main{
    static ArrayList<String> itemstojsonlist = new ArrayList<>();
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static ObjectMapper mapper = new ObjectMapper();
    static StringParser parser;
    public static void main(String[] args) throws IOException{
        System.out.println("Pick Version");
        int choice;
        while(true) {
            try {
                Main.printVersionMenu();
                choice = Integer.parseInt(bufferedReader.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again");
            }
        }
        switch(choice) {
            case 1 -> Main.item(ItemList_1_16_1.values());
            case 2 -> Main.item(ItemList_1_16_5.values());
            default -> {
                System.out.println("Invalid Number, using default");
                Main.item(ItemList_1_16_1.values());
            }
        }
    }
    public static void item(ItemList_1_16_1[] item) throws IOException {
        for (int i = 0; i < item.length; i++) {
            System.out.println(i + 1 + ". " + item[i].display_name);
        }
        System.out.println("Add items with the shown number with the format <item_number>*<count>");
        System.out.println("Put space between each item");
        System.out.println("For example, if you want 10 obsidian trades, 4 ender pearl trades and 3 string trades, you would type:");
        System.out.println("12*10 1*4 2*3");
        System.out.println("Enter items");
        while (true) {
            try {
                parser = new StringParser(bufferedReader.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Improper Format, try again");
            }
        }
        while (true) {
            try {
                for (int i = 0; i < parser.getTotalItemCount(); i++) {
                    for (int j = 0; j < parser.getCount(i); j++) {
                        itemstojsonlist.add(item[parser.getIndex(i) - 1].string);
                    }
                }
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("piglin_bartering.json"), new PrimaryMapper(itemstojsonlist));
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Try again");
                parser = new StringParser(bufferedReader.readLine());
            }
        }
    }
    public static void item(ItemList_1_16_5[] item) throws IOException {
        for (int i = 0; i < item.length; i++) {
            System.out.println(i + 1 + ". " + item[i].display_name);
        }
        System.out.println("Add items with the shown number with the format <item_number>*<count>");
        System.out.println("Put space between each item");
        System.out.println("For example, if you want 10 obsidian trades, 4 ender pearl trades and 3 string trades, you would type:");
        System.out.println("10*10 1*4 2*3");
        System.out.println("Enter items");
        while (true) {
            try {
                parser = new StringParser(bufferedReader.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Improper Format, try again");
            }
        }
        while (true) {
            try {
                for (int i = 0; i < parser.getTotalItemCount(); i++) {
                    for (int j = 0; j < parser.getCount(i); j++) {
                        itemstojsonlist.add(item[parser.getIndex(i) - 1].string);
                    }
                }
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("piglin_bartering.json"), new PrimaryMapper(itemstojsonlist));
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Try again");
                parser = new StringParser(bufferedReader.readLine());
            }
        }
    }
    public static void printVersionMenu() {
        System.out.println("1. 1.16.1");
        System.out.println("2. 1.16.5+");
        System.out.println("Default: 1.16.1");
    }
}