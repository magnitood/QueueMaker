package com.mag;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.util.ArrayList;

public class Maker {
    public static ArrayList<Item> list= new ArrayList<Item>();
    public static ArrayList<JsonObject> json = new ArrayList<>();
    private static int i =0;
    public static void makeList(){
        list.add(new Item("obsidian", 1));
        list.add(new Item("ender_pearl", 2));
    }
    static public void makeJson() {
        Item obby = new Item("obsidian", 1);

        //takes every item in inputted list and converts it into json list
        for(int i=0;i<list.size();i++){
            json.add(i, JsonItemMaker.makeItem(list.get(i)));
        }

        JsonObject model = Json.createObjectBuilder()
                .add("type", "minecraft:barter")
                .add("pools",
                        Json.createArrayBuilder()
                                .add(Json.createObjectBuilder()
                                        .add("rolls", 1)
                                        .add("entries", Maker.sewJsonArray(Json.createArrayBuilder().build())
                                        )
                                )
                ).build();
        System.out.println(model);
    }
    public static JsonArray sewJsonArray(JsonArray recurse){
        JsonArray array = Json.createArrayBuilder().add(json.get(i)).build();
        i++;
        while(i<2){
            Maker.sewJsonArray(array);
        }
        return array;
    }
}

