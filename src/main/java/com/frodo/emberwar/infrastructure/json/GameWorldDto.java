package com.frodo.emberwar.infrastructure.json;

import java.util.List;

/**
 * DTO representing a GameWorld in JSON.
 * Used only for deserialization; not part of the domain.
 */
public class GameWorldDto {

    public int width;
    public int height;
    public List<String> tiles;
    public List<UnitDto> units;

    // Default constructor required by Jackson
    public GameWorldDto() {
    }

    public GameWorldDto(int width, int height, List<String> tiles, List<UnitDto> units) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
        this.units = units;
    }

    @Override
    public String toString() {
        return "GameWorldDto{" +
                "width=" + width +
                ", height=" + height +
                ", tiles=" + tiles +
                ", units=" + units +
                '}';
    }

    /**
     * Inner DTO class representing a unit in the JSON world.
     */
    public static class UnitDto {
        public String symbol; // e.g., "@", "E"
        public int x;
        public int y;

        public UnitDto() {
        }

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
}
