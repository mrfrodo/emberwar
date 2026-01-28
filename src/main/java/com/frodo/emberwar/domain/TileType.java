package com.frodo.emberwar.domain;

public enum TileType {
    FLOOR, WALL, GRASS, WATER, FOREST;

    public String cssClass() {
        return name().toLowerCase();
    }
}