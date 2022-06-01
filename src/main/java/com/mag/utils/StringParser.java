package com.mag.utils;

import java.util.ArrayList;

public class StringParser {
    private ArrayList<Integer> index = new ArrayList<>();
    private ArrayList<Integer> count = new ArrayList<>();

    public StringParser(String text) {
        text = text.trim();
        String[] group=text.split("\\s");
        for(int i=0;i<group.length;i++){
            index.add(parseStringtoIndex(group[i]));
            count.add(parseStringtoCount(group[i]));
        }
    }

    public int getIndex(int i) {
        return index.get(i);
    }
    public int getCount(int i){
        return count.get(i);
    }

    private int parseStringtoIndex(String s) {
        String num = "";
        boolean isParsable = true;
        int i=0;
        while (isParsable) {
            if (s.charAt(i) == '*') {
                isParsable = false;
            } else {
                num+=s.charAt(i);
                i++;
            }
        }
        return Integer.parseInt(num);
    }
    private int parseStringtoCount(String s){
        String num = "";
        int i =0;
        boolean isParsable = true;
        boolean reached = true;
        while(reached){
            if(s.charAt(i) == '*'){
                reached=false;
            } else {
                i++;
            }
        }
        i++;
        while(isParsable){
            if (i<s.length()){
                num+=s.charAt(i);
                ++i;
            }
            else {
                isParsable = false;
            }
        }
        return Integer.parseInt(num);
    }
}