package com.mag;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;

public class Maker {
    static public void makeJson(){
        JsonObject model = Json.createObjectBuilder()
                .add("type","minecraft:barter")
                .add("pools",
                        Json.createArrayBuilder()
                                .add(Json.createObjectBuilder()
                                        .add("rolls", 1)
                                        .add("entries", Json.createArrayBuilder()
                                                .add(ItemMaker.makeItem("obby", 1))
                                        )
                                )
                ).build();
        System.out.println(model);
    }
}
