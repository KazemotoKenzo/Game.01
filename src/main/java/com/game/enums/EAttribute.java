package com.game.enums;

public enum EAttribute {
    STRENGTH("Força"),
    DEXTERITY("Destreza"),
    CONSTITUTION("Constituição"),
    INTELLIGENCE("Inteligência"),
    WISDOM("Sabedoria"),
    CHARISMA("Carisma");

    private final String displayName;

    EAttribute(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}