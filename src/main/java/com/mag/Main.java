package com.mag;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mag.Utils.ScoreMapping;

import java.io.File;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new ScoreMapping(1));
        System.out.println(s);
    }
}