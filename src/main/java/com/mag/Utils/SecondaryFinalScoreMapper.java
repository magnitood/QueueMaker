package com.mag.Utils;

import java.util.ArrayList;

public class SecondaryFinalScoreMapper {
    public String condition = "minecraft:entity_scores";
    public String entity = "this";
    public ArrayList<Object> scores = new ArrayList<>();

    public SecondaryFinalScoreMapper(int times) {
        scores.add(new FinalScoreMapping(times));
    }
}
