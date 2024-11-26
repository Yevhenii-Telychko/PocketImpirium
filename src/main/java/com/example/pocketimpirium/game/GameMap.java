package com.example.pocketimpirium.game;

import java.util.*;

public class GameMap {
    private final List<Sector> sectors;
    private final HexGenerator hexGenerator = new HexGenerator();

    public GameMap() {
        this.sectors = new ArrayList<>();
    }

    public List<Sector> generateSectors(int numberOfSectors) {
        // Generating Sectors
        for (int i = 0; i < numberOfSectors; i++) {
            boolean isTriPrime = i == 3;
            Sector sector = new Sector(i, new ArrayList<>(), isTriPrime);
            List<Hex> hexes = hexGenerator.generateHexes(7, sector);
            sector.getHexes().addAll(hexes);
            sectors.add(sector);
        }
        return sectors;
    }

}


