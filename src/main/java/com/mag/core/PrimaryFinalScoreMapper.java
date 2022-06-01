package com.mag.core;

import java.util.ArrayList;

public class PrimaryFinalScoreMapper {
    public String type = "minecraft:loot_table";
    public String name = "test:bartering/normal";
    public ArrayList<Object> conditions = new ArrayList<>();

    public PrimaryFinalScoreMapper(int times) {
        conditions.add(new SecondaryFinalScoreMapper(times));
    }
}
