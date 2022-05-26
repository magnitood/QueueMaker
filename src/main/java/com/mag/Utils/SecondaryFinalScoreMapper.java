package com.mag.Utils;

import java.util.ArrayList;

public class SecondaryFinalScoreMapper {
    public String condition = "minecraft:entity_scores";
    public String entity = "this";
    public Object scores;

    public SecondaryFinalScoreMapper(int times) {
        this.scores = new FinalScoreMapping(times);
    }
}
