package com.mag.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemMapper {
   public String type = "minecraft:loot_table";
   public String name = "test:bartering/";
   public ArrayList conditions= new ArrayList();

   public ItemMapper(String item, int times) throws JsonProcessingException {
       this.name+=item;
       this.conditions.add(new ScoreMapping(times));
   }
}
