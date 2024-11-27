package com.example.pocketimpirium.game;

import java.util.*;

public class GameMap {
    private List<Sector> sectors = new ArrayList<>();
    private final HexGenerator hexGenerator = new HexGenerator();
    private HexesGraph hexesGraph;
    private final int numberOfSectors;

    public GameMap(int numberOfSectors) {
        this.numberOfSectors = numberOfSectors;
    }

    public List<Sector> generateSectors() {
        // Generating Sectors
        for (int i = 0; i < numberOfSectors; i++) {
            boolean isTriPrime = i == 6;
            Sector sector = new Sector(i+1, new ArrayList<>(), isTriPrime);
            List<Hex> hexes = hexGenerator.generateHexes(7, sector);
            sector.getHexes().addAll(hexes);
            sectors.add(sector);
        }
        return sectors;
    }

    public Map<Hex, List<Hex>> getHexesGraph() {
        return hexesGraph.getHexesGraph();
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void initialize(){
        sectors = generateSectors();
        hexesGraph = new HexesGraph(sectors);
        hexesGraph.initialize();
    }

}


