package com.frodo.emberwar.domain;

public class Tile {

    private final TileType type;
    private Unit unit;

    public Tile(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /** Convenience method for terrain rules */
    public boolean isForest() {
        return type == TileType.FOREST;
    }
}
