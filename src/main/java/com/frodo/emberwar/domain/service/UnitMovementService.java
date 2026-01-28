package com.frodo.emberwar.domain.service;

import com.frodo.emberwar.domain.GameWorld;
import com.frodo.emberwar.domain.Position;
import com.frodo.emberwar.domain.Unit;

/**
 * Domain service responsible for enforcing the rules of unit movement within the game world.
 *
 * This service:
 *   - Validates that a move is legal (within bounds, unoccupied).
 *   - Updates the unit's position in the context of the GameWorld.
 *   - Applies any domain-specific effects triggered by movement (e.g., terrain effects).
 *
 * This is a pure domain service: it contains business logic but no knowledge of persistence,
 * controllers, or application orchestration.
 */
public class UnitMovementService {

    /**
     * Moves a unit to a new position in the game world.
     * Validates that the move is allowed according to the game rules.
     */
    public void moveUnit(Unit unit, Position newPosition, GameWorld world) {
        // Check if the new position is within world bounds
        if (!world.isWithinBounds(newPosition)) {
            throw new IllegalArgumentException("Position out of bounds: " + newPosition);
        }

        // Check if the position is occupied
        if (world.isOccupied(newPosition)) {
            throw new IllegalStateException("Position already occupied: " + newPosition);
        }

        // Perform the move
        Position oldPosition = unit.getPosition();
        unit.setPosition(newPosition);
        world.updateUnitPosition(unit, oldPosition, newPosition);

        // Optionally, trigger other domain rules, e.g., terrain effects
        applyTerrainEffects(unit, world, newPosition);
    }

    private void applyTerrainEffects(Unit unit, GameWorld world, Position pos) {
        // Example: if the unit moves to a forest, reduce movement points
        if (world.getTileAt(pos).isForest()) {
            unit.reduceMovementPoints(1);
        }
    }
}
