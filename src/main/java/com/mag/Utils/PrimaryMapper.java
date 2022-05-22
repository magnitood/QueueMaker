package com.mag.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class PrimaryMapper {
    public String type = "minecraft:barter";
    public ArrayList<Object> pools = new ArrayList<Object>();
    public PrimaryMapper() throws JsonProcessingException {
        SecondaryMapper items = new SecondaryMapper();
        items.addItems("obsidian", 1);
        items.addItems("ender_pearl",2);
        this.pools.add(items);
    }
}
