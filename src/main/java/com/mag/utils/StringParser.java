package com.mag.utils;

import java.util.ArrayList;

public class StringParser {
    private ArrayList<Integer> index = new ArrayList<>();
    private ArrayList<Integer> count = new ArrayList<>();
    private String[] group;

    public StringParser(String text) {
        text = text.trim();
        String[] group=text.split("\\s");
        for (String s : group) {
            index.add(parseStringtoIndex(s));
            count.add(parseStringtoCount(s));
        }
        this.group=group;
    }

    public int getIndex(int i) {
        return index.get(i);
    }
    public int getCount(int i){
        return count.get(i);
    }
    public int getTotalItemCount(){
        return this.group.length;
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