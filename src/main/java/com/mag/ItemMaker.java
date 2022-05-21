package com.mag;

import javax.json.Json;
import javax.json.JsonObject;

public class ItemMaker {
    static JsonObject makeItem(String name, int num){
        return Json.createObjectBuilder()
                .add("type", "mineraft:loot_table")
                .add("name", "test:bartering/"+name)
                .add("condition", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("entity","this")
                                .add("condition", "minecraft:entity_scores")
                                .add("scores", Json.createObjectBuilder()
                                        .add("Times", num)
                                )
                        )
                ).build();
    }
}
