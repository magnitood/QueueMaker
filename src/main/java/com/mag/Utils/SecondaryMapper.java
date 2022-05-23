package com.mag.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;

//this class stitches secandory part of the root structure
public class SecondaryMapper {
    public String rolls = "1";
    public ArrayList<Object> entries = new ArrayList<Object>();
    public void addItems(String name, int times) throws JsonProcessingException {
        this.entries.add(new ItemMapper(name,times));
    }
    public void addLastItem(int times){
        this.entries.add(new PrimaryFinalScoreMapper(times));
    }
}
