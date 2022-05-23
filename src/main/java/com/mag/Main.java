package com.mag;



import com.fasterxml.jackson.databind.ObjectMapper;


import com.mag.Utils.PrimaryMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> items = new ArrayList<>();
        items.add("obsidian");
        items.add("ender_pearl");
        items.add("gravel");
        items.add("water_bottle");
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("piglin_bartering.json"), new PrimaryMapper(items));
    }
}