package com.mag.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//last map for the normal trades
public class FinalScoreMapping {
    public Map<Object, Object> scores = new HashMap<>();
    public FinalScoreMapping(int times){
        scores.put("min", times);
        scores.put("max", 9999);
    }
}

