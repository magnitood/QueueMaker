package com.mag.Utils;

public enum ItemList_1_16_1{
    ENDER_PEARL("ender_pearl", "Ender Pearl"),
    STRING("string", "String"),
    SOUL_SAND("soul_sand", "Soul Sand"),
    QUARTZ("quartz", "Quartz"),
    NETHER_BRICK("nether_bricks", "Nether Bricks"),
    MAGMA_CREAM("magma_cream", "Magma Cream"),
    LEATHER("leather", "Leather"),
    GLOWSTONE_DUST("glowstone_dust", "Glowstone Dust"),
    FIRE_CHARGE("fire_charge", "Fire Charge"),
    SOUL_SPEED_BOOT("soul_speed_boot", "Soul Speed Boot"),
    SOUL_SPEED_BOOK("soul_speed_book", "Soul SPeed Book"),
    OBSIDIAN("obsidian", "Obsidian"),
    IRON_INGOT("iron_nugget", "Iron Nugget"),
    GRAVEL("gravel", "Gravel"),
    FIRE_RES_SPLASH("fire_res_splash", "Splash Potion of Fire Resistance"),
    FIRE_RES("fire_res", "Potion of Fire Resistance"),
    CRYING_OBSIDIAN("crying_obsidian", "Crying Obsidian");
    public final String string;
    public final String display_name;
    ItemList_1_16_1(String string, String display_name){
        this.string = string;
        this.display_name=display_name;
    }
}
