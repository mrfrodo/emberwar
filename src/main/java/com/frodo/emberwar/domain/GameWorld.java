package com.frodo.emberwar.domain;

import java.util.List;

/**
 * Aggregate root. Main domain entity.
 */
public class GameWorld {

    private final int width;
    private final int height;
    private final Map2D map;
    private final List<Unit> units;

    public GameWorld(int width, int height, Map2D map, List<Unit> units) {
        this.width = width;
        this.height = height;
        this.map = map;
        this.units = units;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map2D getMap() {
        return map;
    }

    public List<Unit> getUnits() {
        return units;
    }

    /** Move a piece to a new position */
    public void movePiece(Unit piece, Position newPosition) {
        piece.moveTo(newPosition);
    }
}
