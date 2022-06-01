package com.mag.core;


import java.util.HashMap;
import java.util.Map;
//last map for the normal trades
public class FinalScoreMapping {
    public Map<Object, Object> Times = new HashMap<>();
    public FinalScoreMapping(int times){
        Times.put("min", times);
        Times.put("max", 9999);
    }
}

