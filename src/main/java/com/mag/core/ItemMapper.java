package com.mag.core;

import java.util.ArrayList;

//this class stitches the innermost json structure with the part where you change the names
public class ItemMapper {
   public String type = "minecraft:loot_table";
   public String name = "test:bartering/";
   public ArrayList<Object> conditions= new ArrayList<Object>();

   public ItemMapper(String item, int times){
       this.name+=item;
       this.conditions.add(new ScoreMapping(times));
   }
}
