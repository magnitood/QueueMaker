package com.mag.core;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Generate the actual piglin_bartering.json file
 */
public final class PiglinBarteringJsonGenerator {
    @Getter
    private final ArrayList<BarteringItemStack> barteringItemStackArrayList = new ArrayList<>();

    /**
     * add bartering item stack to the end of the queue
     * @param barteringItemStack bartering items stack
     */
    public void addBarteringItemStack(BarteringItemStack barteringItemStack) {
        barteringItemStackArrayList.add(barteringItemStack);
    }
    /**
     * remove specific bartering items from list
     * @param barteringItemStack bartering item enum
     * @param index index of bartering items located in arraylist
     * @throws ItemNotFoundInIndexException  Item not found in given index
     */
    public void removeStackFromList(BarteringItemStack barteringItemStack, int index) throws ItemNotFoundInIndexException {
        if(barteringItemStackArrayList.get(index).equals(barteringItemStack)){
            barteringItemStackArrayList.remove(index);
        }
        else {
            throw new ItemNotFoundInIndexException();
        }
    }

    /**
     * Remove all instances of a given stack from list
     * @param barteringItemStack bartering item stack to remove
     */
    public void removeStackFromList(BarteringItemStack barteringItemStack) {
        for (int i = 0; i < barteringItemStackArrayList.size(); i++) {
            try {
                removeStackFromList(barteringItemStack, i);
            } catch (ItemNotFoundInIndexException ignored) {}
        }
    }

    /**
     * removes every bartering item from the list
     */
    public void clearList(){
        barteringItemStackArrayList.clear();
    }

    /**
     * generate piglin_bartering.json file
     * @return the piglin_bartering.json file containing the generated bartering queue
     */
    public File generatePiglinBarteringDotJson(File pathToDatapackDirectory) throws IOException {
        return this.generateJson(this.generateBarteringItemsArrayList(barteringItemStackArrayList), pathToDatapackDirectory);
    }
    private ArrayList<BarteringItems> generateBarteringItemsArrayList(ArrayList<BarteringItemStack> barteringItemStackArrayList){
        ArrayList<BarteringItems> barteringItemsArrayList = new ArrayList<>();
        for(int i = 0; i< barteringItemStackArrayList.size(); i++){
            int count = barteringItemStackArrayList.get(i).getCount();
            for(int j=0;j<count;j++){
                barteringItemsArrayList.add(barteringItemStackArrayList.get(i).getBarteringItems());
            }
        }
        return barteringItemsArrayList;
    }
    private File generateJson(ArrayList<BarteringItems> barteringItemsArrayList, File piglin_bartering_json) throws IOException {
        if(piglin_bartering_json.isDirectory()){
            throw new IllegalArgumentException("Not a directory");
        }
        JsonFactory jsonFactory = new JsonFactory();
        int times;
        JsonGenerator jsonGenerator = jsonFactory.createGenerator(piglin_bartering_json, JsonEncoding.UTF8);
        jsonGenerator=jsonGenerator.useDefaultPrettyPrinter();
        jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("type","minecraft:barter");
            jsonGenerator.writeArrayFieldStart("pools");
                jsonGenerator.writeStartObject();
                    jsonGenerator.writeNumberField("rolls", 1);
                    jsonGenerator.writeArrayFieldStart("entries");
                        for(times=0;times<barteringItemsArrayList.size();times++){
                            System.out.println("adding "+barteringItemsArrayList.get(times).display_name);
                            jsonGenerator.writeStartObject();
                                jsonGenerator.writeStringField("type","minecraft:loot_table");
                                jsonGenerator.writeStringField("name", "test:bartering/"+barteringItemsArrayList.get(times).json_text);
                                jsonGenerator.writeArrayFieldStart("conditions");
                                    jsonGenerator.writeStartObject();
                                        jsonGenerator.writeStringField("entity","this");
                                        jsonGenerator.writeStringField("condition","minecraft:entity_scores");
                                        jsonGenerator.writeObjectFieldStart("scores");
                                            jsonGenerator.writeNumberField("Times",times+1);
                                        jsonGenerator.writeEndObject();
                                    jsonGenerator.writeEndObject();
                                jsonGenerator.writeEndArray();
                            jsonGenerator.writeEndObject();
                        }
                        jsonGenerator.writeStartObject();
                            jsonGenerator.writeStringField("type","minecraft:loot_table");
                            jsonGenerator.writeStringField("name", "test:bartering/normal");
                            jsonGenerator.writeArrayFieldStart("conditions");
                                jsonGenerator.writeStartObject();
                                jsonGenerator.writeStringField("entity","this");
                                jsonGenerator.writeStringField("condition","minecraft:entity_scores");
                                    jsonGenerator.writeObjectFieldStart("scores");
                                        jsonGenerator.writeObjectFieldStart("Times");
                                            jsonGenerator.writeNumberField("min", times+1);
                                            jsonGenerator.writeNumberField("max", 999);
                                        jsonGenerator.writeEndObject();
                                jsonGenerator.writeEndObject();
                                jsonGenerator.writeEndObject();
                            jsonGenerator.writeEndArray();
                        jsonGenerator.writeEndObject();
                    jsonGenerator.writeEndArray();
                jsonGenerator.writeEndObject();
            jsonGenerator.writeEndArray();
            jsonGenerator.writeEndObject();
            jsonGenerator.close();
        return piglin_bartering_json;
    }
    private static class ItemNotFoundInIndexException extends Exception{
        public ItemNotFoundInIndexException(String messageToPrint){
            super(messageToPrint);
        }
        public ItemNotFoundInIndexException(){}
    }
}
