package com.frodo.emberwar.infrastructure.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frodo.emberwar.domain.*;
import com.frodo.emberwar.domain.spi.WorldLoaderPort;
import com.frodo.emberwar.domain.spi.WorldLoadingException;
import com.frodo.emberwar.domain.spi.WorldSource;
import com.frodo.emberwar.infrastructure.world.JsonWorldSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Driven adapter: loads a GameWorld from a JSON file.
 */
@Component
public class JsonWorldLoader implements WorldLoaderPort {

    private final ObjectMapper mapper;

    @Autowired
    public JsonWorldLoader(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public GameWorld loadWorld(WorldSource source) {
        try (InputStream is = source.open()) {
            // Read JSON from the port (any implementation of WorldSource)
            GameWorldDto dto = mapper.readValue(is, GameWorldDto.class);

            Map2D map = parseMap(dto);
            List<Unit> units = parseUnits(dto.units);

            return new GameWorld(dto.width, dto.height, map, units);

        } catch (Exception e) {
            throw new WorldLoadingException("Failed to load world", e);
        }
    }

    private Map2D parseMap(GameWorldDto dto) {
        Tile[][] tiles = new Tile[dto.height][dto.width];

        for (int y = 0; y < dto.height; y++) {
            String row = dto.tiles.get(y);
            for (int x = 0; x < dto.width; x++) {
                TileType type = TileLegend.fromChar(row.charAt(x));
                tiles[y][x] = new Tile(type);
            }
        }

        return new Map2D(tiles);
    }

    private List<Unit> parseUnits(List<GameWorldDto.UnitDto> unitDtos) {
        List<Unit> units = new ArrayList<>();
        for (GameWorldDto.UnitDto dto : unitDtos) {
            Player owner = mapSymbolToPlayer(dto.symbol);
            Unit unit = new Unit(owner, new Position(dto.x, dto.y));
            units.add(unit);
        }
        return units;
    }

    /**
     * Example: map JSON symbol to a Player instance.
     * You can expand this as needed.
     */
    private Player mapSymbolToPlayer(String symbol) {
        return switch (symbol) {
            case "@" -> Player.PLAYER;    // hero is PLAYER
            case "E" -> Player.COMPUTER;  // enemy is COMPUTER
            default -> Player.PLAYER;     // fallback, choose PLAYER by default
        };
    }

    // --- TileLegend helper ---
    private static class TileLegend {
        static TileType fromChar(char c) {
            return switch (c) {
                case '.' -> TileType.FLOOR;
                case '#' -> TileType.WALL;
                default -> throw new IllegalArgumentException("Unknown tile: " + c);
            };
        }
    }
}
