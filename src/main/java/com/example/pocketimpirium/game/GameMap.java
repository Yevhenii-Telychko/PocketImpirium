package com.example.pocketimpirium.game;

import java.util.*;

public class GameMap {
    private final List<Sector> sectors = new ArrayList<>();
    private final CoordinatePlane plane = new CoordinatePlane();
    private final HexGenerator hexGenerator = new HexGenerator(plane);
    private HexesGraph hexesGraph;
    private List<List<String>> configuration = new ArrayList<>();
//    private final int numberOfSectors;

    public GameMap(List<List<String>> configuration) {
        this.configuration = configuration;
    }

    public void generateSideSectors() {
        // Generating Sectors
//        String[] sides = {"CENTRAL", "NE", "E", "SE", "SW", "W", "NW"};
        int sectorID = 0;
        for (List<String> sides : configuration) {
            String sectorName = "";
            System.out.println(sides);
            for(String side : sides) {
                sectorID += 1;
                sectorName += side + " ";
                Sector sector = new Sector(sectorID, new ArrayList<>(), sectorName);
                hexGenerator.generateHexes(7, sector);
                List<Hex> hexes = hexGenerator.getHexes();
                sector.getHexes().addAll(hexes);
                Hex centralHex = sector.getHexes().getFirst();
                centralHex.setType("CENTRAL");
                sectors.add(sector);
            }

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


