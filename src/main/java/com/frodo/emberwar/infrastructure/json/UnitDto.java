package com.frodo.emberwar.infrastructure.json;


/**
 * DTO representing a unit in the JSON world.
 * Used only for deserialization; not part of the domain.
 */
public class UnitDto {

    public String symbol; // JSON symbol, e.g., "@", "E"
    public int x;         // X coordinate in the map
    public int y;         // Y coordinate in the map

    // Default constructor required by Jackson
    public UnitDto() {
    }

    // Optional convenience constructor
    public UnitDto(String symbol, int x, int y) {
        this.symbol = symbol;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "UnitDto{" +
                "symbol='" + symbol + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
