package com.frodo.emberwar.domain;

public class Map2D {

    private final Tile[][] tiles;

    public Map2D(Tile[][] tiles) {
        this.tiles = tiles;
    }

    /** Access by Position */
    public Tile tileAt(Position pos) {
        return tiles[pos.y()][pos.x()];
    }

    /** tiles[y][x] */
    public Tile getTile(int x, int y) {
        return tiles[y][x];
    }

    public int getWidth() {
        return tiles[0].length;
    }

    public int getHeight() {
        return tiles.length;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
