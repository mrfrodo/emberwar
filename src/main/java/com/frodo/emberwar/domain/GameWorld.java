package com.frodo.emberwar.domain;

import java.util.List;

/**
 * Aggregate root representing the game world.
 *
 * Responsibilities:
 *   - Maintains the overall state of the world, including its dimensions, map, and units.
 *   - Enforces invariants for units and positions (e.g., bounds checking, occupancy).
 *   - Provides operations that modify the state of the world in a consistent, domain-safe way.
 *
 * As an aggregate root, all changes to units or the map should go through this class
 * or domain services that operate on it.
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

    public Tile getTileAt(Position pos) {
        return map.tileAt(pos); // use tileAt(Position)
    }
    /**
     * Checks if the given position is currently occupied by a unit.
     */
    public boolean isOccupied(Position pos) {
        return units.stream()
                .anyMatch(u -> u.getPosition().equals(pos));
    }

    /**
     * Returns true if the position is within the bounds of the game world.
     */
    public boolean isWithinBounds(Position pos) {
        int x = pos.x();
        int y = pos.y();
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    /**
     * Moves a unit to a new position.
     * Throws exceptions if the move is invalid.
     */
    public void moveUnit(Unit unit, Position newPosition) {
        if (!isWithinBounds(newPosition)) {
            throw new IllegalArgumentException("Position out of bounds: " + newPosition);
        }

        if (isOccupied(newPosition)) {
            throw new IllegalStateException("Position already occupied: " + newPosition);
        }

        Position oldPosition = unit.getPosition();
        unit.moveTo(newPosition);
        updateUnitPosition(unit, oldPosition, newPosition);
    }

    /**
     * Updates internal state after a unit moves.
     * Currently simple, but can handle events, visibility, etc.
     */
    public void updateUnitPosition(Unit unit, Position oldPosition, Position newPosition) {
        // In this simple example, nothing extra is required.
        // You could trigger observers, recalculate vision, etc.
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

}
