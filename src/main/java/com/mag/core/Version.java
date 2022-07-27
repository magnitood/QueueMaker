package com.mag.core;

public enum Version {
    BOTH("Both"),
    VERSION_1161("1.16.1"),
    VERSION_1165("1.16.5");
    public final String version_string;
    Version(String version_string){
        this.version_string = version_string;
    }
}
