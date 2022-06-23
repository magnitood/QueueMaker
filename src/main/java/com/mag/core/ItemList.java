package com.mag.core;

public enum ItemList {
    ENDER_PEARL("ender_pearl", "Ender Pearl",Constants.BOTH),
    STRING("string", "String",Constants.BOTH),
    SOUL_SAND("soul_sand", "Soul Sand",Constants.BOTH),
    QUARTZ("quartz", "Quartz",Constants.BOTH),
    NETHER_BRICK("nether_bricks", "Nether Bricks", Constants.BOTH),
    MAGMA_CREAM("magma_cream", "Magma Cream", "1.16.1"),
    LEATHER("leather", "Leather",Constants.BOTH),
    GLOWSTONE_DUST("glowstone_dust", "Glowstone Dust","1.16.1"),
    FIRE_CHARGE("fire_charge", "Fire Charge",Constants.BOTH),
    SOUL_SPEED_BOOT("soul_speed_boot", "Soul Speed Boot",Constants.BOTH),
    SOUL_SPEED_BOOK("soul_speed_book", "Soul SPeed Book",Constants.BOTH),
    OBSIDIAN("obsidian", "Obsidian",Constants.BOTH),
    WATER_BOTTLE("water_bottle","Water Bottle","1.16.5"),
    IRON_INGOT("iron_nugget", "Iron Nugget",Constants.BOTH),
    GRAVEL("gravel", "Gravel",Constants.BOTH),
    FIRE_RES_SPLASH("fire_res_splash", "Splash Potion of Fire Resistance",Constants.BOTH),
    FIRE_RES("fire_res", "Potion of Fire Resistance",Constants.BOTH),
    BLACKSTONE("blackstone","Blackstone","1.16.5"),
    CRYING_OBSIDIAN("crying_obsidian", "Crying Obsidian",Constants.BOTH),
    SPECTRAL_ARROW("spectral_arrow","Spectral Arrow","1.16.5");
    public final String string;
    public final String display_name;
    public final String version;
    private final String both =Constants.BOTH;
    ItemList(String string, String display_name, String version){
        this.string = string;
        this.display_name=display_name;
        this.version = version;
    }
    private class Constants{
        private static String BOTH = "Both";
    }
}
