package com.hella.apprentice.project.enums;

public enum Race {
    Orc,
    Elf,
    Human,
    Undead;

    public static Race byName(String name) {
        for (Race race: values()){
            if (race.name().equalsIgnoreCase(name)){
                return race;
            }
        }
        return null;
    }

}
