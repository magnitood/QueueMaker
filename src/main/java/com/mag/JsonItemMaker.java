package com.mag;

import javax.json.Json;
import javax.json.JsonObject;

public class JsonItemMaker {
    static JsonObject makeItem(Item item){
        return Json.createObjectBuilder()
                .add("type", "minecraft:loot_table")
                .add("name", "test:bartering/"+item.name)
                .add("condition", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("entity","this")
                                .add("condition", "minecraft:entity_scores")
                                .add("scores", Json.createObjectBuilder()
                                        .add("Times", item.times)
                                )
                        )
                ).build();
    }
}
