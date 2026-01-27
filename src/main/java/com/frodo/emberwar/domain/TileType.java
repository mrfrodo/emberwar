package com.frodo.emberwar.domain;

public enum TileType {
    FLOOR, WALL, GRASS, WATER;

    public String cssClass() {
        return name().toLowerCase();
    }
}