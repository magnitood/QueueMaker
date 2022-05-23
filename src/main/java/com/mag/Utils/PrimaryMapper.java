package com.mag.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
//stitches final json structure to the root covering
public class PrimaryMapper {
    //private int i = 1;
    public String type = "minecraft:barter";
    public ArrayList<Object> pools = new ArrayList<Object>();
    private SecondaryMapper secondaryMapper;
    public PrimaryMapper(ArrayList<String> items) throws JsonProcessingException {
        this.secondaryMapper = new SecondaryMapper();
        //secondaryMapper.addItems("obsidian", 1);
        //secondaryMapper.addItems("ender_pearl",2);
        //secondaryMapper.addLastItem(3);
        //this.pools.add(secondaryMapper);
        //idk how but it fucking works now lmao
        int i= 1;
        try {
            while (i<=items.size()) {
                this.secondaryMapper.addItems(items.get(i-1), i);
                i++;
            }
            this.secondaryMapper.addLastItem(i);
            this.pools.add(secondaryMapper);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
