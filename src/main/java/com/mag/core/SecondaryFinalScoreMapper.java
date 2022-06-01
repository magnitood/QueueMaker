package com.mag.core;

public class SecondaryFinalScoreMapper {
    public String condition = "minecraft:entity_scores";
    public String entity = "this";
    public Object scores;

    public SecondaryFinalScoreMapper(int times) {
        this.scores = new FinalScoreMapping(times);
    }
}
