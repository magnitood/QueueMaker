package com.mag.core;

public enum BarteringItems {
    ENDER_PEARL("ender_pearl", "Ender Pearl", Version.BOTH),
    STRING("string", "String", Version.BOTH),
    SOUL_SAND("soul_sand", "Soul Sand", Version.BOTH),
    QUARTZ("quartz", "Quartz", Version.BOTH),
    NETHER_BRICK("nether_bricks", "Nether Bricks", Version.BOTH),
    MAGMA_CREAM("magma_cream", "Magma Cream", Version.VERSION_1161),
    LEATHER("leather", "Leather", Version.BOTH),
    GLOWSTONE_DUST("glowstone_dust", "Glowstone Dust", Version.VERSION_1161),
    FIRE_CHARGE("fire_charge", "Fire Charge", Version.BOTH),
    SOUL_SPEED_BOOT("soul_speed_boot", "Soul Speed Boot", Version.BOTH),
    SOUL_SPEED_BOOK("soul_speed_book", "Soul Speed Book", Version.BOTH),
    OBSIDIAN("obsidian", "Obsidian", Version.BOTH),
    WATER_BOTTLE("water_bottle","Water Bottle", Version.VERSION_1165),
    IRON_INGOT("iron_nugget", "Iron Nugget", Version.BOTH),
    GRAVEL("gravel", "Gravel", Version.BOTH),
    FIRE_RES_SPLASH("fire_res_splash", "Splash Potion of Fire Resistance", Version.BOTH),
    FIRE_RES("fire_res", "Potion of Fire Resistance", Version.BOTH),
    BLACKSTONE("blackstone","Blackstone", Version.VERSION_1165),
    CRYING_OBSIDIAN("crying_obsidian", "Crying Obsidian", Version.BOTH),
    SPECTRAL_ARROW("spectral_arrow","Spectral Arrow", Version.VERSION_1165);
    public final String json_text;
    public final String display_name;
    public final Version version;
    BarteringItems(String json_text, String display_name, Version version){
        this.json_text = json_text;
        this.display_name=display_name;
        this.version = version;
    }
}
