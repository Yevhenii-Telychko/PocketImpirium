package com.example.pocketimpirium.game;

import java.util.*;

public class GameMap {
    private final List<Sector> sectors = new ArrayList<>();
    private final CoordinatePlane plane = new CoordinatePlane();
    private final HexGenerator hexGenerator = new HexGenerator(plane);
    private HexesGraph hexesGraph;
    private final List<List<String>> configuration;

    public GameMap(List<List<String>> configuration) {
        this.configuration = configuration;
    }

    public void generateSideSectors() {
        int sectorID = 0;
        for (List<String> sides : configuration) {
            String sectorName = "";
            for(String side : sides) {
                sectorID += 1;
                sectorName += side + " ";
                Sector sector = new Sector(sectorID, new ArrayList<>(), sectorName);
                hexGenerator.generateHexes(7, sector);
                List<Hex> hexes = hexGenerator.getHexes();
                sector.setHexes(hexes);
                Hex centralHex = sector.getHexes().getFirst();
                centralHex.setType("CENTRAL");
                sectors.add(sector);
            }

        }
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void initialize(){
        this.generateSideSectors();
        this.hexesGraph = new HexesGraph(sectors);
    }

    public HexesGraph getGraph() {
        return hexesGraph;
    }

}


