package com.example.pocketimpirium.game;

import java.util.*;

public class GameMap {
    private final List<Sector> sectors = new ArrayList<>();
    private final CoordinatePlane plane = new CoordinatePlane();
    private final HexGenerator hexGenerator = new HexGenerator(plane);
    private HexesGraph hexesGraph;
    private final int numberOfSectors;

    public GameMap(int numberOfSectors) {
        this.numberOfSectors = numberOfSectors;
    }

    public void generateSideSectors() {
        // Generating Sectors
        String[] sides = {"CENTRAL", "NE", "E", "SE", "SW", "W", "NW"};
        for (int i = 0; i < numberOfSectors; i++) {
            Sector sector = new Sector(i+1, new ArrayList<>(), sides[i]);
            hexGenerator.generateHexes(7, sector);
            List<Hex> hexes = hexGenerator.getHexes();
            sector.getHexes().addAll(hexes);
            Hex centralHex = sector.getHexes().getFirst();
            centralHex.setType("CENTRAL");
            sectors.add(sector);
        }
    }

    public Map<Hex, List<Hex>> getHexesGraph() {
        return hexesGraph.getHexesGraph();
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void initialize(){
       this.generateSideSectors();
    }

}


