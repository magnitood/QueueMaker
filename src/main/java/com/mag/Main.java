package com.mag;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mag.Utils.ItemMapper;
import com.mag.Utils.ScoreMapping;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new ScoreMapping(1));
        //System.out.println(s);
        ArrayList list= new ArrayList();
        list.add(new ItemMapper("obsidian",1));
        list.add(new ItemMapper("ender_pearl",2));
        String y = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        System.out.println(y);
    }
}