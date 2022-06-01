package com.mag.core;

import java.util.ArrayList;

//this class stitches secandory part of the root structure
public class SecondaryMapper {
    public int rolls = 1;
    public ArrayList<Object> entries = new ArrayList<Object>();
    public void addItems(String name, int times){
        this.entries.add(new ItemMapper(name,times));
    }
    public void addLastItem(int times){
        this.entries.add(new PrimaryFinalScoreMapper(times));
    }
}
