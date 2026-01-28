package com.frodo.emberwar.domain;

public class Unit {

    private final Player owner;
    private Position position;
    private int movementPoints;

    public Unit(Player owner, Position position) {
        this.owner = owner;
        this.position = position;
    }

    public Player getOwner() { return owner; }
    public Position getPosition() { return position; }

    public void moveTo(Position newPosition) {
        if (newPosition == null) throw new IllegalArgumentException("Position cannot be null");
        this.position = newPosition;
    }

    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }

    /** Reduces movement points (e.g., due to terrain effects) */
    public void reduceMovementPoints(int points) {
        movementPoints -= points;
        if (movementPoints < 0) movementPoints = 0; // optional: clamp at 0
    }
}
