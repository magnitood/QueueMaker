package com.mag.Utils;

import java.util.HashMap;
import java.util.Map;

public class ScoreMapping {
    public String entity = "this";
    public String condition = "minecraft:entity_scores";
    //private int n;
    public Map<String, Integer> scores = new HashMap<String, Integer>();


    public ScoreMapping(int n) {
        scores.put("Times", n);
    }
}
