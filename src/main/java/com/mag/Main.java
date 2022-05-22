package com.mag;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mag.Utils.ItemMapper;
import com.mag.Utils.PrimaryMapper;
import com.mag.Utils.ScoreMapping;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new PrimaryMapper());
        System.out.println(s);
    }
}