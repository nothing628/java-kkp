package com.kkp.myapp.enums;

public enum UserLevel {
    Administrator("Administrator"),
    HRD("HRD"),
    Manager("Manager");

    private final String levelName;

    UserLevel(String level) {
        this.levelName = level;
    }

    public String getLevel() {
        return this.levelName;
    }
}
